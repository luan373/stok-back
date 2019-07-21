package br.com.bg.stok.orm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bg.stok.orm.interfaces.IGenericService;
import br.com.bg.stok.orm.model.Motoboy;
import br.com.bg.stok.orm.repository.MotoBoyRepository;

@Service
public class MotoBoyService implements IGenericService<Motoboy> {

	@Autowired
	private MotoBoyRepository repository;

	@Transactional(readOnly = true)
	public List<Motoboy> findAll() {
		return repository.findAll();
	}

	public Motoboy save(Motoboy entity) {
		return repository.save(entity);
	}

	@Transactional(readOnly = true)
	public Optional<Motoboy> findById(long id) {
		return repository.findById(id);
	}

	public void delete(Motoboy entity) {
		repository.delete(entity);
	}

	public void deleteById(long id) {
		repository.deleteById(id);
	}

	public long count() {
		return repository.count();
	}

}
