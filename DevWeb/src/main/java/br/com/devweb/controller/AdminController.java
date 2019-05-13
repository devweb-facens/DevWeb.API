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

import br.com.devweb.models.Admin;
import br.com.devweb.services.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Admin>> getAll(){
		List<Admin> admins = service.getAll();
		return admins!=null ? ResponseEntity.ok(admins):ResponseEntity.noContent().build();
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Admin> getOne(@PathVariable("id") int id){
		Admin admin = service.getOne(id);
		return admin!=null ? ResponseEntity.ok(admin):ResponseEntity.noContent().build();
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Admin> save(@RequestBody Admin admin){
		 
		admin = service.insert(admin);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(admin.getId()).toUri();
		return admin.getId() != null ? ResponseEntity.created(uri).build() : ResponseEntity.noContent().build();
	
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Admin> delete(@PathVariable("id") int id){
		Admin admin = service.delete(id);
		return admin==null ? ResponseEntity.ok(admin) : ResponseEntity.noContent().build();
	}
	
	
	
}
