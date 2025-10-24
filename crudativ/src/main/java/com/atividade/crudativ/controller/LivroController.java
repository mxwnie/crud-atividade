package com.atividade.crudativ.controller;

import com.atividade.crudativ.model.Livro;
import com.atividade.crudativ.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @PostMapping
    public Livro cadastrarLivro(@RequestBody Livro livro){
        return livroService.cadastrarLivro(livro);
    }

    @GetMapping
    private List<Livro> listarLivro(){
        return livroService.listarLivro();
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id){
        livroService.deletarLivro(id);
    }
}
