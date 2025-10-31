package com.atividade.crudativ.service;

import com.atividade.crudativ.model.Livro;
import com.atividade.crudativ.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public Livro cadastrarLivro(Livro livro){
        return livroRepository.save(livro);
    }

    public List<Livro> listarLivro(){
        return livroRepository.findAll();
    }

    public void deletarLivro(Long id){
        livroRepository.deleteById(id);
    }
    public Livro atualizarLivro(Long id, Livro livro){
        Livro livroExistente = livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        livroExistente.setTitulo(livro.getTitulo());
        livroExistente.setAutor(livro.getAutor());
        livroExistente.setEditora(livro.getEditora());
        livroExistente.setAnoPublicacao(livro.getAnoPublicacao());
        return livroRepository.save(livroExistente);
    }
    
}
