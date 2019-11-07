package br.com.bg.stok.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

import br.com.bg.stok.orm.model.Cliente;
import br.com.bg.stok.orm.service.ClienteService;
import br.com.bg.stok.rest.exception.AppException;
import br.com.bg.stok.rest.exception.NotFoundException;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping
	public List<Cliente> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	public Cliente findById(@PathVariable("id") Long id) {
		Optional<Cliente> optional = service.findById(id);

		if (!optional.isPresent()) {
			throw new NotFoundException("Cliente não encontrado.");
		}

		return optional.get();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente resource) {
		Preconditions.checkNotNull(resource);
		Cliente cliente = null;
		try {
			cliente = service.save(resource);
		} catch (DataIntegrityViolationException e) {
			throw new AppException("Cliente já cadastrado.");
		}
		return cliente;
	}

	@PutMapping()
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Cliente resource) {
		Preconditions.checkNotNull(resource);
		try {
			service.save(resource);
		} catch (DataIntegrityViolationException e) {
			throw new AppException("Cliente já cadastrado.");
		}
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		service.deleteById(id);
	}

}