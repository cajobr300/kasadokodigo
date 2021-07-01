package com.br.casadokodigo.kasadokodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    AutorRespository autorRespository;

    public AutorController(AutorRespository autorRespository){
        this.autorRespository = autorRespository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarAutor(@RequestBody @Valid AutorRequest autorRequest , UriComponentsBuilder uriComponentsBuilder){
        Autor autor = autorRequest.toModel();
        Autor aSalvo = autorRespository.save(autor);
        return ResponseEntity.ok().body(new AutorResponse(aSalvo));
    }

}
