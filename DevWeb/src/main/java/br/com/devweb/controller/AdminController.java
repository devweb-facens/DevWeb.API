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

import br.com.devweb.models.Admin;
import br.com.devweb.repository.AdminRepository;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Admin>> getAll(){
		List<Admin> admin = adminRepository.findAll();
		
		return admin!=null ? ResponseEntity.ok(admin): ResponseEntity.noContent().build();
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Admin> getOne(@PathVariable("id") int id){
		Admin admin = adminRepository.findById(id);
		return admin!=null?ResponseEntity.ok(admin):ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Admin> save(@RequestBody Admin admin){
		long cont = adminRepository.count();
		adminRepository.save(admin);
		if(cont<adminRepository.count()) {
			return ResponseEntity.ok(admin);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Admin> delete(@PathVariable("id") int id){
		adminRepository.deleteById(id);
		Admin admin = adminRepository.findById(id);
		return admin==null? ResponseEntity.ok(admin) : ResponseEntity.noContent().build();
	}
	
}
