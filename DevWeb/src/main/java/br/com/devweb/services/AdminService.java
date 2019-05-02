package br.com.devweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devweb.models.Admin;
import br.com.devweb.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repo;
	
	public List<Admin> getAllAdmin(){
		List<Admin> admin = repo.findAll();
		return admin;
	}
	
	public Admin getOneAdmin(int id) {
		Admin admin = repo.findById(id);
		return admin;
	}
	
	public boolean saveAdmin(Admin admin) {
		long count = repo.count();
		repo.save(admin);
		if(count<repo.count()) {
			return true;
		}
		return false;
	}
	
	public Admin deleteAdmin(int id) {
		repo.deleteById(id);
		Admin admin = repo.findById(id);
		return admin;
	}
	
}
