package br.com.devweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.devweb.models.Admin;
import br.com.devweb.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	
	public List<Admin> getAll(){
		List<Admin> admin = repo.findAll();
		return admin;
	}
	
	public Admin getOne(int id) {
		Admin admin = repo.findById(id);
		return admin;
	}
	
	public Admin insert(Admin admin) {
		admin.setId(null);
		Admin ad = repo.findByEmail(admin.getEmail());
		if(ad == null) {
			admin.setSenha(pe.encode(admin.getSenha()));
			
			return repo.save(admin);
		}
		return null;
	
	}
	
	public Admin delete(int id) {
		repo.deleteById(id);
		Admin admin = repo.findById(id);
		return admin;
	}
	
}
