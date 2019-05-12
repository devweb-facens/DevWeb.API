package br.com.devweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devweb.models.Disciplina;
import br.com.devweb.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repo;
	
	public List<Disciplina> getAll(){
		return repo.findAll();
	}
	
	public Disciplina getOne(int id) {
		return repo.findById(id);
	}
	
	public Disciplina insert(Disciplina disciplina) {
		return repo.save(disciplina);
	}
	
	public Disciplina delete(int id) {
		repo.deleteById(id);
		Disciplina disciplina = repo.findById(id);
		return disciplina;
	}
	
}
