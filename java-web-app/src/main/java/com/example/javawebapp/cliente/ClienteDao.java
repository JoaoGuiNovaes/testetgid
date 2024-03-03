package com.example.javawebapp.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.javawebapp.db.Conexao;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class ClienteDao {
    public static Cliente cadastrar(String cpf, String nome, String email, String senha, String cnpjEmpresa) {
        Cliente cliente = null;
        String hashSenha = BCrypt.withDefaults().hashToString(12, senha.toCharArray());
        String sql = "INSERT INTO cliente (cpf, nome, email, senha, cnpj_empresa) VALUES (?, ?, ?, ?, ?);";
        
        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, cpf);
            statement.setString(2, nome);
            statement.setString(3, email);
            statement.setString(4, hashSenha);
            statement.setString(5, cnpjEmpresa);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                cliente = new Cliente(rs.getInt(1), cpf, nome, email, hashSenha,  cnpjEmpresa);
            }

            rs.close();

            return cliente;  
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Cliente buscarPorId(Integer id) {
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Cliente(
                    rs.getInt("id_cliente"),
                    rs.getString("cpf"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
                );
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static Cliente buscarPorCnpjEmpresaCliente(Integer id) {
        String sql = "SELECT * FROM cliente WHERE cnpj_empresa = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Cliente(
                    rs.getInt("id"),
                    rs.getString("cpf"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("cnpj_empresa")
                );
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static Cliente buscarPorEmail(String email) {
        String sql = "SELECT * FROM cliente WHERE email = ?;";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Cliente(
                    rs.getInt("id_cliente"),
                    rs.getString("cpf"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha")
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
        Cliente cliente = buscarPorEmail(email);
        if (cliente != null) {
            BCrypt.Result result = BCrypt.verifyer().verify(senha.toCharArray(), cliente.getSenha());
            return result.verified;
        }
        return false;
    }
    public static Boolean existeComEmail(String email) {
        return buscarPorEmail(email) != null;
    }
}

