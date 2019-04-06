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

import br.com.devweb.models.Admin;
import br.com.devweb.repository.AdminRepository;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;
	
	@GetMapping("/getAll")
	public List<Admin> getAll(){	
		return adminRepository.findAll();
	}
	
	@GetMapping("/getOne/{id}")
	public Optional<Admin> getOne(@PathVariable("id") int id){
		return adminRepository.findById(id);
	}
	
	@PostMapping()
	public ResponseEntity<Object> save(@RequestBody Admin admin){
		return new ResponseEntity<>(adminRepository.save(admin), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public HttpStatus delete(@PathVariable("id") int id){
		Optional<Admin> admin = adminRepository.findById(id);
		if(admin!=null) {
			adminRepository.deleteById(id);
			return HttpStatus.OK;
		}else {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}
}
