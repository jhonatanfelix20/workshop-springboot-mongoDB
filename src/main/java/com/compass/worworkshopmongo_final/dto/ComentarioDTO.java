package com.compass.worworkshopmongo_final.dto;

import java.io.Serializable;
import java.util.Date;

public class ComentarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String text;
	private Date data;
	private AutorDTO autor;
	
	public ComentarioDTO() {
		
	}

	public ComentarioDTO(String text, Date data, AutorDTO autor) {
		super();
		this.text = text;
		this.data = data;
		this.autor = autor;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public AutorDTO getAutor() {
		return autor;
	}

	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}
	
	
}
