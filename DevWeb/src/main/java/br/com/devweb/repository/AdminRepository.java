package br.com.devweb.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.devweb.models.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer>{

	List<Admin> findAll();
	Admin findById(int id);
}
