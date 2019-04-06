package br.com.devweb.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.devweb.models.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Integer> {

}
