package br.com.devweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devweb.models.Curso;
import br.com.devweb.repository.CursoRepository;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping("/getAll")
	public List<Curso> getAll(){	
		return cursoRepository.findAll();
	}
	
	@GetMapping("/getOne/{id}")
	public Optional<Curso> getOne(@PathVariable("id") int id){
		return cursoRepository.findById(id);
	}
	
	@PostMapping()
	public ResponseEntity<Object> save(@RequestBody Curso curso){
		return new ResponseEntity<>(cursoRepository.save(curso), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public HttpStatus delete(@PathVariable("id") int id){
		Optional<Curso> curso = cursoRepository.findById(id);
		if(curso!=null) {
			cursoRepository.deleteById(id);
			return HttpStatus.OK;
		}else {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}
}
