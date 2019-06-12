package com.example.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algamoney.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	// Define aqui que está usando esta interface extendendo os métodos de
	// JpaRepository, onde:
	// Categoria seria a classe e Long o tipo da chave primária
}
