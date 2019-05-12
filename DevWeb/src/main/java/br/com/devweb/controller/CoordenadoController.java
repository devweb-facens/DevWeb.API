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

import br.com.devweb.models.Coordenador;
import br.com.devweb.services.CoordenadorService;



@RestController
@RequestMapping("/api/coordenado")
public class CoordenadoController {

	@Autowired
	private CoordenadorService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Coordenador>> getAll(){
		List<Coordenador> lista = service.getAll();
		
		return lista != null ? ResponseEntity.ok(lista) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Coordenador> getOne(@PathVariable("id") int id){
		Coordenador coord = service.getOne(id);
		return coord != null ? ResponseEntity.ok(coord) : ResponseEntity.noContent().build();
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<Coordenador> save(@RequestBody Coordenador coord){
		boolean salvo = service.save(coord);
		return salvo ? ResponseEntity.ok(coord) : ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Coordenador> delete(@PathVariable("id") int id){
		Coordenador coord = service.delete(id);
		return coord == null ? ResponseEntity.ok(coord) : ResponseEntity.noContent().build();
	}
}
