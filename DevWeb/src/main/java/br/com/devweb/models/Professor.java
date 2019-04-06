package br.com.devweb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	//@ManyToMany(mappedBy="")
	//private Diciplina diciplina;
	
}
