package com.example.javawebapp.empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.javawebapp.db.Conexao;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class EmpresaDAO {
    public static Empresa cadastrar(String cnpj, String nome, String senha, double taxa) {
        Empresa empresa = null;
        String hashSenha = BCrypt.withDefaults().hashToString(12, senha.toCharArray());
        String sql = "INSERT INTO empresa (cnpj, nome, senha, saldo, taxa) VALUES (?, ?, ?, ?, ?);";
        
        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, cnpj);
            statement.setString(2, nome);
            statement.setString(3, hashSenha);
            statement.setDouble(4, 0);
            statement.setDouble(5, taxa);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                empresa = new Empresa(rs.getInt(1), cnpj, nome, hashSenha, (double) 0, taxa);
            }

            rs.close();

            return empresa;  
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Empresa buscarPorId(Integer id) {
        String sql = "SELECT * FROM empresa WHERE id_empresa = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Empresa(
                    rs.getInt("id"), 
                    rs.getString("cnpj"), 
                    rs.getString("nome"), 
                    rs.getString("senha"), 
                    rs.getDouble("saldo"),
                    rs.getDouble("taxa")
                );
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static Empresa buscarPorCnpj(String cnpj) {
        String sql = "SELECT * FROM empresa WHERE cnpj = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, cnpj);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Empresa(
                    rs.getInt("id_empresa"), 
                    rs.getString("cnpj"), 
                    rs.getString("nome"), 
                    rs.getString("senha"), 
                    rs.getDouble("saldo"),
                    rs.getDouble("taxa")
                );
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static Boolean login(String email, String senha) {
        Empresa empresa = buscarPorCnpj(email);
        if (empresa != null) {
            BCrypt.Result result = BCrypt.verifyer().verify(senha.toCharArray(), empresa.getSenha());
            return result.verified;
        }
        return false;
    }

    public static Boolean existeComCnpj(String email) {
        return buscarPorCnpj(email) != null;
    }

    public static boolean processarTransacao(String cnpjEmpresa, String tipoTransacao, double valor, String emailUsuario) {
        String sql = "";
        // Verificar o tipo de transação e construir a atualização do saldo
        if ("saque".equalsIgnoreCase(tipoTransacao)) {
            sql = "UPDATE empresa SET saldo = saldo - ? WHERE cnpj = ?";
        } else if ("deposito".equalsIgnoreCase(tipoTransacao)) {
            sql = "UPDATE empresa SET saldo = saldo + ? WHERE cnpj = ?";
        } else {
            return false;
        }
    
        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setDouble(1, valor);
            statement.setString(2, cnpjEmpresa);
    
            int linhasAfetadas = statement.executeUpdate();
    
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
    

