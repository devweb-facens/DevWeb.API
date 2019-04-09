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

import br.com.devweb.models.Disciplina;
import br.com.devweb.repository.DisciplinaRepository;

@RestController
@RequestMapping("/api/disciplina")
public class DiciplinaController {

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Disciplina>> getAll(){
		List<Disciplina> diciplina = disciplinaRepository.findAll();
		
		return diciplina!=null ? ResponseEntity.ok(diciplina): ResponseEntity.noContent().build();
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Disciplina> getOne(@PathVariable("id") int id){
		Disciplina diciplina = disciplinaRepository.findById(id);
		return diciplina!=null?ResponseEntity.ok(diciplina):ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Disciplina> save(@RequestBody Disciplina diciplina){
		long cont = disciplinaRepository.count();
		disciplinaRepository.save(diciplina);
		if(cont<disciplinaRepository.count()) {
			return ResponseEntity.ok(diciplina);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Disciplina> delete(@PathVariable("id") int id){
		disciplinaRepository.deleteById(id);
		Disciplina diciplina = disciplinaRepository.findById(id);
		return diciplina==null? ResponseEntity.ok(diciplina) : ResponseEntity.noContent().build();
	}
}
