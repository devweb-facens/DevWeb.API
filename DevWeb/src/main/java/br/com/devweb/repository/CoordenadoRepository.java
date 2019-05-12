package br.com.devweb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.devweb.models.Coordenador;

public interface CoordenadoRepository extends CrudRepository<Coordenador, Integer>{
	
	List<Coordenador> findAll();
	Coordenador findById(int id);
}

