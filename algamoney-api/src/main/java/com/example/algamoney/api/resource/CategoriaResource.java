package com.example.algamoney.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.event.RecursoCriadoEvent;
import com.example.algamoney.api.model.Categoria;
import com.example.algamoney.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	// Dizendo com esta anotação para INJETAR a implementação da interface aqui
	// nesta classe
	@Autowired
	private CategoriaRepository repositorio;

	@Autowired
	private ApplicationEventPublisher publisher;

	// Estou dizendo aqui que este método quando acessado
	// http://MEUSERVER:8080/categorias usando GET vai chamar por padrão este método
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
	public List<Categoria> listar() {
		return repositorio.findAll();
	}

	// Caso seja acessado como GET em http://MEUSERVER:8080/categorias/metodo2
	@GetMapping("/metodo2")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
	public List<Categoria> listar2() {
		return repositorio.findAll();
	}

	// Somente salva a nova categoria, retorna 201=CREATED mas não devolve no Body a
	// Categoria criada
	// Mapeando este método quando chamado o POST e dizendo que a resposta será
	// 201:CREATED
	// @PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')")
	@ResponseStatus(HttpStatus.CREATED)
	public void criar(@RequestBody Categoria categoria) {
		repositorio.save(categoria);
	}

	// Mapeando este método quando chamado o POST e dizendo que a resposta será
	// 201:CREATED
	// Retorna também em Location o código da categoria que foi criada
	// Também retorna no body a categoria criada
	// Não precisa mais do @ResponseStatus pois o return está colocando
	@PostMapping
	// @ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')")
	public ResponseEntity<Categoria> criar2(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria catSalva = repositorio.save(categoria);

		// Insere o código q foi criado no final da URL
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
//				.buildAndExpand(catSalva.getCodigo()).toUri();
//		response.setHeader("Location", uri.toASCIIString());
//
//		return ResponseEntity.created(uri).body(catSalva);	

		publisher.publishEvent(new RecursoCriadoEvent(this, response, catSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(catSalva);
	}

	// Retorna a categoria conforme o código q foi passado
	// Trata caso o codigo informado nao seja encontrado no banco
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
	@GetMapping("/{codigo}")
	public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo) {
		if (repositorio.findOne(codigo) == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(repositorio.findOne(codigo));
		}
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)	
	public void deletar(@PathVariable Long codigo) {
		repositorio.delete(codigo);
	}
}
