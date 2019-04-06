package br.com.devweb.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.devweb.models.Diciplina;

public interface ProfessorRepository extends CrudRepository<Diciplina, Integer>{

}
