package br.com.bg.stok.rest.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.bg.stok.orm.model.Motoboy;
import br.com.bg.stok.orm.service.MotoBoyService;
import br.com.bg.stok.rest.exception.NotFoundException;

@RestController
@RequestMapping("/motoBoy")
public class MotoBoyController {

	@Autowired
	private MotoBoyService service;

	@GetMapping
	public List<Motoboy> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	public Motoboy findById(@PathVariable("id") Long id) {
		Optional<Motoboy> motoboy = service.findById(id);
		
		if (!motoboy.isPresent()) {
			throw new NotFoundException("MotoBoy não encontrado.");
		}

		return motoboy.get();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Motoboy create(@RequestBody Motoboy resource) {
		Preconditions.checkNotNull(resource);
		return service.save(resource);
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable("id") Long id, @RequestBody Motoboy resource) {
		Preconditions.checkNotNull(resource);
		service.save(resource);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		service.deleteById(id);
	}
}
