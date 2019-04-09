package br.com.devweb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.devweb.models.Coordenado;

public interface CoordenadoRepository extends CrudRepository<Coordenado, Integer>{
	
	List<Coordenado> findAll();
	Coordenado findById(int id);
}

