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
import br.com.devweb.services.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Admin>> getAll(){
		List<Admin> admins = service.getAllAdmin();
		return admins!=null ? ResponseEntity.ok(admins):ResponseEntity.noContent().build();
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Admin> getOne(@PathVariable("id") int id){
		Admin admin = service.getOneAdmin(id);
		return admin!=null ? ResponseEntity.ok(admin):ResponseEntity.noContent().build();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Admin> save(@RequestBody Admin admin){
		boolean salvo = service.saveAdmin(admin);
		return salvo ? ResponseEntity.ok(admin):ResponseEntity.noContent().build();
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Admin> delete(@PathVariable("id") int id){
		Admin admin = service.deleteAdmin(id);
		return admin==null ? ResponseEntity.ok(admin) : ResponseEntity.noContent().build();
	}
	
	
	
}
