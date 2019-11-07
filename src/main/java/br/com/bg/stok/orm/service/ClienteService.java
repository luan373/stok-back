package br.com.bg.stok.orm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bg.stok.orm.interfaces.IGenericService;
import br.com.bg.stok.orm.model.Cliente;
import br.com.bg.stok.orm.repository.ClienteRepository;

@Service
public class ClienteService implements IGenericService<Cliente> {

	@Autowired
	private ClienteRepository repository;

	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente save(Cliente entity) {
		return repository.save(entity);
	}

	@Transactional(readOnly = true)
	public Optional<Cliente> findById(long id) {
		return repository.findById(id);
	}

	public void delete(Cliente entity) {
		repository.delete(entity);
	}

	public void deleteById(long id) {
		repository.deleteById(id);
	}

	public long count() {
		return repository.count();
	}

}
