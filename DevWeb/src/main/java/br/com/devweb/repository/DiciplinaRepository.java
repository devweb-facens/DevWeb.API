package br.com.devweb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.devweb.models.Diciplina;

public interface DiciplinaRepository extends CrudRepository<Diciplina, Integer>{

	List<Diciplina> findAll();
	Diciplina findById(int id);
}
