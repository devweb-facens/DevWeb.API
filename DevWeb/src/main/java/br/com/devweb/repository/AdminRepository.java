package br.com.devweb.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.devweb.models.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer>{

	List<Admin> findAll();
	Admin findById(int id);
}
