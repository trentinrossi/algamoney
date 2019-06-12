package com.example.algamoney.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.LancamentoRepository;
import com.example.algamoney.api.repository.PessoaRepository;
import com.example.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository repository;

	@Autowired
	private PessoaRepository pessoaRepository;

	// Valida valores antes de inserir
	public Lancamento inserir(Lancamento lancamento) {

		// Valida se pessoa informada existe
		Pessoa p = pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
		if (p == null || p.isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}

		return repository.save(lancamento);
	}
}
