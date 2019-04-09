package br.com.devweb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.devweb.models.Disciplina;

public interface DisciplinaRepository extends CrudRepository<Disciplina, Integer>{

	List<Disciplina> findAll();
	Disciplina findById(int id);
}
