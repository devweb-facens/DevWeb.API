package br.com.devweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devweb.models.Professor;
import br.com.devweb.repository.ProfessorRepository;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

	@Autowired
	private ProfessorRepository professorRepository;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Professor>> getAll(){
		List<Professor> professor = professorRepository.findAll();
		
		return professor!=null ? ResponseEntity.ok(professor): ResponseEntity.noContent().build();
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Professor> getOne(@PathVariable("id") int id){
		Professor professor = professorRepository.findById(id);
		return professor!=null?ResponseEntity.ok(professor):ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Professor> save(@RequestBody Professor professor){
		long cont = professorRepository.count();
		professorRepository.save(professor);
		if(cont<professorRepository.count()) {
			return ResponseEntity.ok(professor);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Professor> delete(@PathVariable("id") int id){
		professorRepository.deleteById(id);
		Professor professor = professorRepository.findById(id);
		return professor==null? ResponseEntity.ok(professor) : ResponseEntity.noContent().build();
	}
}
