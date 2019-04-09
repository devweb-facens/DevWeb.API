package br.com.devweb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.devweb.models.Curso;

public interface CursoRepository extends CrudRepository<Curso, Integer>{
	
	List<Curso> findAll();
	Curso findById(int id);
}
