package com.joaog4briel.ninjas.entity;

import jakarta.persistence.*;



@Entity //Cria a entidade no banco de dados
@Table (name = "tb_cadastro") //Da o nome da tabela no banco de dados
public class NinjaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    @ManyToOne //Um ninja vai ter apenas uma missão
    @JoinColumn(name = "missoes_id") // Foreing key ou chave estrangeira
    private MissoesEntity missoes;

    public NinjaEntity() {}

    public NinjaEntity(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public int getIdade() {return idade;}

    public void setIdade(int idade) {this.idade = idade;}
}
