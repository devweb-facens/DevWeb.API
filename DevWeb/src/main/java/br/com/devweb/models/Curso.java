package br.com.devweb.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Curso 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="Nome",length=120, nullable=false)
	private String nome;
	
	@OneToMany(mappedBy = "curso")
    private List<Coordenado> coordenadores;
	
	@ManyToMany(mappedBy="cursos")
	private List<Disciplina> disciplinas;
	
	public Curso() {
		coordenadores = new ArrayList<Coordenado>();
	}

	public Curso(String nome, List<Coordenado> coordenadores) {
		this.nome = nome;
		this.coordenadores = coordenadores;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Coordenado> getCoordenadores() {
		return coordenadores;
	}
	public void setCoordenadores(List<Coordenado> coordenadores) {
		this.coordenadores = coordenadores;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
}
