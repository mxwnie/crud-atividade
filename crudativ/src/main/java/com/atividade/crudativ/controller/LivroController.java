package com.atividade.crudativ.controller;

import com.atividade.crudativ.model.Livro;
import com.atividade.crudativ.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/livros")
@CrossOrigin(
       origins = {"http://127.0.0.1:5500", "http://localhost:5500"},
       allowedHeaders = {"*"},
       methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}
)
public class LivroController {
    @Autowired
    private LivroService livroService;

    @PostMapping
    public Livro cadastrarLivro(@RequestBody Livro livro){
        return livroService.cadastrarLivro(livro);
    }

    @Operation(summary = "listar livros")
    @GetMapping
    private List<Livro> listarLivro(){
        return livroService.listarLivro();
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id){
        livroService.deletarLivro(id);
    }
    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable Long id, @RequestBody Livro livro){
        return livroService.atualizarLivro(id, livro);
    }
}
