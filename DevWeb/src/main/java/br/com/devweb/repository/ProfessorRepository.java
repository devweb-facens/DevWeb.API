package br.com.devweb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.devweb.models.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Integer> {

	List<Professor> findAll();
	Professor findById(int id);
}
