package com.br.casadokodigo.kasadokodigo.categoria;

import com.br.casadokodigo.kasadokodigo.validation.UniqueValue;

import javax.validation.constraints.NotBlank;


public class CategoriaDTO {
    @NotBlank
    @UniqueValue(instanceClass = Categoria.class, field = "nome")
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria converter() {
        return new Categoria(this.nome);
    }
}