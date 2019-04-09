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

import br.com.devweb.models.Coordenado;
import br.com.devweb.models.Curso;
import br.com.devweb.repository.CoordenadoRepository;
import br.com.devweb.repository.CursoRepository;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
	private CoordenadoRepository coordenadoRepository;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Curso>> getAll(){
		List<Curso> curso = cursoRepository.findAll();
		
		return curso!=null ? ResponseEntity.ok(curso): ResponseEntity.noContent().build();
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Curso> getOne(@PathVariable("id") int id){
		Curso curso = cursoRepository.findById(id);
		return curso!=null?ResponseEntity.ok(curso):ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Curso> save(@RequestBody Curso curso){
		long cont = cursoRepository.count();
		
		cursoRepository.save(curso);
		
		/*for (Coordenado c : curso.getCoordenadores()) {
			if (coordenadoRepository.existsById(c.getId()))
			{
				c.setCurso(curso);
				coordenadoRepository.save(c);
			}
		}*/
		
		
		if(cont<cursoRepository.count()) {
			return ResponseEntity.ok(curso);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Curso> delete(@PathVariable("id") int id){
		cursoRepository.deleteById(id);
		Curso curso = cursoRepository.findById(id);
		return curso==null? ResponseEntity.ok(curso) : ResponseEntity.noContent().build();
	}
}
