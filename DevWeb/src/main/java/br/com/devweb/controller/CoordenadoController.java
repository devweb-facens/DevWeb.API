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
import br.com.devweb.repository.CoordenadoRepository;

@RestController
@RequestMapping("/api/coordenado")
public class CoordenadoController {

	@Autowired
	private CoordenadoRepository coordenadoRepository;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Coordenado>> getAll(){
		List<Coordenado> coordenado = coordenadoRepository.findAll();
		
		return coordenado!=null ? ResponseEntity.ok(coordenado): ResponseEntity.noContent().build();
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Coordenado> getOne(@PathVariable("id") int id){
		Coordenado coordenado = coordenadoRepository.findById(id);
		return coordenado!=null?ResponseEntity.ok(coordenado):ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Coordenado> save(@RequestBody Coordenado coordenado){
		long cont = coordenadoRepository.count();
		coordenadoRepository.save(coordenado);
		if(cont<coordenadoRepository.count()) {
			return ResponseEntity.ok(coordenado);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Coordenado> delete(@PathVariable("id") int id){
		coordenadoRepository.deleteById(id);
		Coordenado coordenado = coordenadoRepository.findById(id);
		return coordenado==null? ResponseEntity.ok(coordenado) : ResponseEntity.noContent().build();
	}
	
}
