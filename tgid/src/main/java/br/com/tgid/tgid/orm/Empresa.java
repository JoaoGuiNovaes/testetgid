package br.com.tgid.tgid.orm;

import jakarta.persistence.*;
@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String cnpj;
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double saldo;

    @Column(nullable = false)
    private Double taxa;

    @Deprecated
    public Empresa() { }

    public Empresa(Long id, String cnpj, String nome, Double saldo, Double taxa) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.saldo = saldo;
        this.taxa = taxa;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", cnpj='" + cnpj + '\'' +
                ", nome='" + nome + '\'' +
                ", saldo=" + saldo +
                ", taxa=" + taxa +
                '}';
    }
}
