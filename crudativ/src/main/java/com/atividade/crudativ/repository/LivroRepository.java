package com.atividade.crudativ.repository;

import com.atividade.crudativ.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
