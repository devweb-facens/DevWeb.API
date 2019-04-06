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

import br.com.devweb.models.Diciplina;
import br.com.devweb.repository.DiciplinaRepository;

@RestController
@RequestMapping("/api/diciplina")
public class DiciplinaController {

	@Autowired
	private DiciplinaRepository diciplinaRepository;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Diciplina>> getAll(){
		List<Diciplina> diciplina = diciplinaRepository.findAll();
		
		return diciplina!=null ? ResponseEntity.ok(diciplina): ResponseEntity.noContent().build();
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Diciplina> getOne(@PathVariable("id") int id){
		Diciplina diciplina = diciplinaRepository.findById(id);
		return diciplina!=null?ResponseEntity.ok(diciplina):ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Diciplina> save(@RequestBody Diciplina diciplina){
		long cont = diciplinaRepository.count();
		diciplinaRepository.save(diciplina);
		if(cont<diciplinaRepository.count()) {
			return ResponseEntity.ok(diciplina);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Diciplina> delete(@PathVariable("id") int id){
		diciplinaRepository.deleteById(id);
		Diciplina diciplina = diciplinaRepository.findById(id);
		return diciplina==null? ResponseEntity.ok(diciplina) : ResponseEntity.noContent().build();
	}
}
