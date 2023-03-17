package com.generation.refugiomental.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_postagens")
public class Postagens {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 5, max = 255, message = "O atributo não pode estar vazio")
	private String informacoes;

	@NotBlank
	@Size(min = 10, max = 45, message = "O atributo não pode estar vazio")
	private String tipo_profissional;

	@NotBlank
	@Size(min = 15, max = 80, message = "O atributo não pode estar vazio")
	private String atendimento;

	@NotBlank
	@Size(min = 5, max = 100, message = "O atributo não pode estar vazio")
	private String modalidade_categoria;

	@NotBlank
	private int avaliacao;

	@NotBlank
	@Size(min = 5, max = 255, message = "O atributo não pode estar vazio")
	private String image_link;

	@ManyToOne
	@JsonIgnoreProperties("postagens")
	private Tema tema;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

	public String getTipo_profissional() {
		return tipo_profissional;
	}

	public void setTipo_profissional(String tipo_profissional) {
		this.tipo_profissional = tipo_profissional;
	}

	public String getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(String atendimento) {
		this.atendimento = atendimento;
	}

	public String getModalidade_categoria() {
		return modalidade_categoria;
	}

	public void setModalidade_categoria(String modalidade_categoria) {
		this.modalidade_categoria = modalidade_categoria;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getImage_link() {
		return image_link;
	}

	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

}