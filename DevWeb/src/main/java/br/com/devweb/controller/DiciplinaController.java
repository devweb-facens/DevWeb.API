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

import br.com.devweb.models.Disciplina;
import br.com.devweb.services.DisciplinaService;

@RestController
@RequestMapping("/api/disciplina")
public class DiciplinaController {

	@Autowired
	private DisciplinaService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Disciplina>> getAll(){
		List<Disciplina> lista = service.getAll();
		return lista != null ? ResponseEntity.ok(lista) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Disciplina> getOne(@PathVariable("id") int id){
		Disciplina dis = service.getOne(id);
		return dis != null ? ResponseEntity.ok(dis) : ResponseEntity.noContent().build();
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Disciplina> insert(@RequestBody Disciplina dis){
		dis = service.insert(dis);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dis.getId()).toUri();
		return dis.getId() != null ? ResponseEntity.created(uri).build() : ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Disciplina> delete(@PathVariable("id") int id){
		Disciplina dis = service.delete(id);
		return dis == null ? ResponseEntity.ok(dis) : ResponseEntity.noContent().build();
		
	}
	
}
