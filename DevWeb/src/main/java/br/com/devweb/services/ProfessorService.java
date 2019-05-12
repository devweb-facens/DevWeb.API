package br.com.devweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devweb.models.Professor;
import br.com.devweb.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository repo;
	
	
	public List<Professor> getAll(){
		return repo.findAll();
	}
	
	public Professor getOne(int id) {
		return repo.findById(id);
	}
	
	public Professor insert(Professor prof) {
		return repo.save(prof);
	}
	
	public Professor delete(int id) {
		repo.deleteById(id);
		Professor prof = repo.findById(id);
		return prof;
	}
}
