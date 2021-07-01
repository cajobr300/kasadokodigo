package com.br.casadokodigo.kasadokodigo.autor;

import com.br.casadokodigo.kasadokodigo.book.Livro;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
@Entity(name = "autor")
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, length = 400)
    private String descricao;
    private LocalDateTime criadoEm;

    @Deprecated
    public Autor() {
    }

    public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.criadoEm= LocalDateTime.now();
    }

    public Autor(Long id) {
        this.id = id;
    }


    public void setId(Long id) {
        this.id = id;
    }



    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                ", criadoEm=" + criadoEm +
                '}';
    }
}
