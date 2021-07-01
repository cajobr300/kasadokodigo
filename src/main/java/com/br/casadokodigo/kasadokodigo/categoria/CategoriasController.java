package com.br.casadokodigo.kasadokodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
    @Autowired
    CategoriaRepository repository;

    @PostMapping
    public ResponseEntity<Categoria> cadastrar(@RequestBody @Valid CategoriaDTO dto) {
        Categoria categoria = dto.converter();
        repository.save(categoria);
        return ResponseEntity.ok(categoria);
    }
}