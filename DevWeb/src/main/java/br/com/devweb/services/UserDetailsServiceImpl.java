package br.com.devweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.devweb.models.Admin;
import br.com.devweb.repository.AdminRepository;
import br.com.devweb.security.UserSS;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private AdminRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Admin admin = repo.findByEmail(email);
		if(admin==null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS();
	}

}
