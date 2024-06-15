package com.compass.worworkshopmongo_final.dto;

import java.io.Serializable;

import com.compass.workshopmongo_final.domain.User;

public class AutorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	
	public AutorDTO() {
		
	}
	
	public AutorDTO(User obj) {
		id = obj.getId();
		nome = obj.getnome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
