package br.com.devweb.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.devweb.models.Professor;
import br.com.devweb.services.ProfessorService;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Professor>> getAll(){
		List<Professor> profs = service.getAll();
		return profs != null ? ResponseEntity.ok(profs) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Professor> getOne(@PathVariable("id") int id){
		Professor prof = service.getOne(id);
		return prof!=null ? ResponseEntity.ok(prof) : ResponseEntity.noContent().build();
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Professor> insert(@RequestBody Professor prof){
		prof = service.insert(prof);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prof.getId()).toUri();
		return prof.getId() != null ? ResponseEntity.created(uri).build() : ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Professor> delete(@PathVariable("id") int id){
		Professor prof = service.delete(id);
		return prof == null ? ResponseEntity.ok(prof) : ResponseEntity.noContent().build();
	}
	
}
