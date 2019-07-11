package br.com.bg.stok.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.bg.stok.orm.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("SELECT u FROM Usuario u WHERE u.usuario = :usuario and u.senha = :senha")
	Usuario porUsuarioSenha(@Param("usuario") String usuario, @Param("senha") String senha);
}