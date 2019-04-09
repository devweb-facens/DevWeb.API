package br.com.devweb.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Professor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="Nome",length=120, nullable=false)
	private String nome;
	@Column(name="Email",length=80, nullable=false)
	private String email;
	@Column(name="Senha",length=30, nullable=false)
	private String senha;
	@Column(name="Telefone",length=20, nullable=false)
	private String telefone;
	@Column(name="ProfessorResponsavel", nullable=false)
	private boolean isProfessorResponsavel;
	
	@ManyToMany
	@JoinTable(name="Professor_Disciplina", 
		joinColumns={@JoinColumn(name="professor_id")}, 
		inverseJoinColumns={@JoinColumn(name="disciplina_id")})
	private List<Disciplina> diciplinas;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public boolean isProfessorResponsavel() {
		return isProfessorResponsavel;
	}
	public void setProfessorResponsavel(boolean isProfessorResponsavel) {
		this.isProfessorResponsavel = isProfessorResponsavel;
	}
	
	//@ManyToMany
	//private List<Diciplina> diciplinas;
	
	
	
}
