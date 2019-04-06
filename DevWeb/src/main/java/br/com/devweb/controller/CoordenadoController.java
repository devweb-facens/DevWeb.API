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

import br.com.devweb.models.Coordenado;
import br.com.devweb.models.Curso;
import br.com.devweb.repository.CoordenadoRepository;

@RestController
@RequestMapping("/api/coordenado")
public class CoordenadoController {

	@Autowired
	private CoordenadoRepository coordenadoRepository;
	
	@GetMapping("/getAll")
	public List<Coordenado> getAll(){	
		return coordenadoRepository.findAll();
	}
	
	@GetMapping("/getOne/{id}")
	public Optional<Coordenado> getOne(@PathVariable("id") int id){
		return coordenadoRepository.findById(id);
	}
	
	@PostMapping()
	public ResponseEntity<Object> save(@RequestBody Coordenado coordenado){
		return new ResponseEntity<>(coordenadoRepository.save(coordenado), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public HttpStatus delete(@PathVariable("id") int id){
		Optional<Coordenado> coordenado = coordenadoRepository.findById(id);
		if(coordenado!=null) {
			coordenadoRepository.deleteById(id);
			return HttpStatus.OK;
		}else {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}
}
