package br.com.devweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devweb.models.Curso;
import br.com.devweb.repository.CursoRepository;

@Service
public class CursoService {

	
	@Autowired
	private CursoRepository repo;
	
	public List<Curso> getAll(){
		List<Curso> lista = repo.findAll();
		return lista;
	}
	
	public Curso getOne(int id) {
		Curso curso = repo.findById(id);
		return curso;
	}
	
	public Curso insert(Curso curso) {
		curso.setId(null);
		return repo.save(curso);
	}
	
	public Curso delete(int id) {
		repo.deleteById(id);
		Curso curso = repo.findById(id);
		return curso;
	}
}
