package com.br.casadokodigo.kasadokodigo.book;

import com.br.casadokodigo.kasadokodigo.autor.Autor;
import com.br.casadokodigo.kasadokodigo.categoria.Categoria;
import com.br.casadokodigo.kasadokodigo.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {
    @NotBlank
    @UniqueValue(instanceClass = Categoria.class, field = "nome")
    @JsonProperty
    private String titulo;

    @NotBlank
    @JsonProperty
    private String sumario;

    @NotBlank
    @JsonProperty
    @Size(max = 500)
    private String resumo;

    @Min(value = 20)
    @NotNull
    @JsonProperty
    private BigDecimal preco;

    @Min(value = 100)
    @NotNull
    @JsonProperty
    private Integer numeroPaginas;

    @NotBlank
    @JsonProperty
    private String isbn;


    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataLancamento;

    @JsonProperty
    private Long categoria;

    @JsonProperty
    private Long autor;

    public LivroRequest(@NotBlank String titulo, @NotBlank String sumario, @NotBlank @Size(max = 500) String resumo, @Min(value = 20) @NotNull BigDecimal preco, @Min(value = 100) @NotNull Integer numeroPaginas, @NotBlank String isbn, @Future LocalDate dataLancamento, @Valid Long categoria, @Valid Long autor) {
        this.titulo = titulo;
        this.sumario = sumario;
        this.resumo = resumo;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataLancamento = dataLancamento;
        this.categoria = categoria;
        this.autor = autor;
    }
    public Livro toModel(){
        return new Livro(titulo,sumario,resumo,preco,numeroPaginas,isbn,dataLancamento,new Categoria(categoria),new Autor(autor) );
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}