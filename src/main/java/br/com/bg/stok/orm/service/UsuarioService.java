package br.com.bg.stok.orm.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.bg.stok.orm.model.Usuario;
import br.com.bg.stok.orm.repository.UsuarioRepository;

@Component
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Transactional
	public void update(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).get();
	}

	@Transactional
	public void addAll(Collection<Usuario> usuarios) {
		usuarioRepository.saveAll(usuarios);
	}

	@Transactional
	public Long create(Usuario usuario) {
		return usuarioRepository.save(usuario).getId();
	}

	@Transactional
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}

}
