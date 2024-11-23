package com.github.gregoryced.gs_2semestre_micro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Energia {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column()
	private String nome;
	
	@Column()
	private String tipo;
	
	@Column()
	private String material;
	
	@Column()
	private boolean sustentavel;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public boolean isSustentavel() {
		return sustentavel;
	}

	public void setSustentavel(boolean sustentavel) {
		this.sustentavel = sustentavel;
	}
	
	
}
