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

import br.com.devweb.models.Curso;
import br.com.devweb.services.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

	@Autowired
	private CursoService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Curso>> getAll(){
		List<Curso> cursos = service.getAll();
		return cursos != null ? ResponseEntity.ok(cursos) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Curso> getOne(@PathVariable("id") int id) {
		Curso curso = service.getOne(id);
		return curso != null ? ResponseEntity.ok(curso) : ResponseEntity.noContent().build();
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Curso> save(@RequestBody Curso curso){
		 curso = service.insert(curso);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(curso.getId()).toUri();
		 return curso.getId() != null ? ResponseEntity.created(uri).build() : ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Curso> delete(@PathVariable("id") int id){
		Curso curso = service.delete(id);
		return curso == null ? ResponseEntity.ok(curso) : ResponseEntity.noContent().build();
	}
	
}
