package com.br.casadokodigo.kasadokodigo.book;

import com.br.casadokodigo.kasadokodigo.autor.AutorRespository;
import com.br.casadokodigo.kasadokodigo.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import net.bytebuddy.asm.Advice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarLivro(@RequestBody @Valid LivroRequest livroRequest) {
        Livro livro = livroRequest.toModel();
        livroRepository.save(livro);
        return ResponseEntity.ok(new LivroResponse(livro));
    }
}

