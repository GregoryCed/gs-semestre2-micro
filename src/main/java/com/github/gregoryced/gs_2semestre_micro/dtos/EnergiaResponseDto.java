package com.github.gregoryced.gs_2semestre_micro.dtos;

public class EnergiaResponseDto {
	private String nome;
	private String tipo;
	private String material;
	private boolean sustentavel;
	
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
