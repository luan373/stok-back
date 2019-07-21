package br.com.bg.stok.orm.interfaces;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T> {

	List<T> findAll();

	T save(T entity);

	Optional<T> findById(long id);

	void delete(T entity);

	void deleteById(long id);

	long count();

}
