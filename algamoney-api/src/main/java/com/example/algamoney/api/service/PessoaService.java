package com.example.algamoney.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Endereco;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository repository;

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa p = retornaPessoaByCodigo(codigo);
		BeanUtils.copyProperties(pessoa, p, "codigo");
		return repository.save(p);
	}

	public void atualizarAtivo(Long codigo, Boolean ativo) {
		Pessoa p = retornaPessoaByCodigo(codigo);
		p.setAtivo(ativo);
		repository.save(p);
	}

	public Pessoa retornaPessoaByCodigo(Long codigo) {
		Pessoa pessoaSalva = repository.findOne(codigo);

		if (pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}

		return pessoaSalva;
	}

	public void atualizarEndereco(Long codigo, Endereco endereco) {
		Pessoa p = retornaPessoaByCodigo(codigo);
		p.setEndereco(endereco);
		repository.save(p);
	}
}
