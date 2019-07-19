package br.com.bg.stok.orm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.bg.stok.orm.model.enums.CategoriaMotoboy;

@Entity
public class Motoboy extends AuditModel {

	private static final long serialVersionUID = -1989279167854870348L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String placa;
	private String cpf;
	private String nrHabilitacao;
	private CategoriaMotoboy categoriaMotoboy;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getnrHabilitacao() {
		return nrHabilitacao;
	}

	public void setnrHabilitacao(String nrHabilitacao) {
		this.nrHabilitacao = nrHabilitacao;
	}

	public CategoriaMotoboy getCategoriaMotoboy() {
		return categoriaMotoboy;
	}

	public void setCategoriaMotoboy(CategoriaMotoboy categoriaMotoboy) {
		this.categoriaMotoboy = categoriaMotoboy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
}
