package br.com.bg.stok.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bg.stok.orm.model.Motoboy;

@Repository
public interface MotoBoyRepository extends JpaRepository<Motoboy, Long> {

}
