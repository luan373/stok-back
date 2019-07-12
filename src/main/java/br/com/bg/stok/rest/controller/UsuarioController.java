package br.com.bg.stok.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;

import br.com.bg.stok.orm.model.Usuario;
import br.com.bg.stok.orm.service.UsuarioService;
import br.com.bg.stok.rest.exception.NotFoundException;
import br.com.bg.stok.rest.util.RestPreconditions;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public List<Usuario> findAll() {
		return usuarioService.findAll();
	}

	@GetMapping(value = "/{id}")
	public Usuario findById(@PathVariable("id") Long id) throws NotFoundException {
		return RestPreconditions.checkFound(usuarioService.findById(id));
	}

	@PostMapping("/porUsuarioSenha")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void porUsuarioSenha(@RequestBody Usuario resource) throws NotFoundException {
		Usuario usuario = usuarioService.porUsuarioSenha(resource);

		if (usuario == null) {
			throw new NotFoundException();
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Long create(@RequestBody Usuario resource) {
		Preconditions.checkNotNull(resource);
		return usuarioService.create(resource);
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("id") Long id, @RequestBody Usuario resource) {
		Preconditions.checkNotNull(resource);
		RestPreconditions.checkNotNull(usuarioService.findById(resource.getId()));
		usuarioService.update(resource);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		usuarioService.deleteById(id);
	}
}
