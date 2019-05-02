package br.com.devweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devweb.models.Coordenador;
import br.com.devweb.repository.CoordenadoRepository;

@Service
public class CoordenadorService {

	
	@Autowired
	private CoordenadoRepository repo;
	
	public List<Coordenador> getAllCoordenador(){
		List<Coordenador> coords = repo.findAll();
		return coords;
	}
	
	public Coordenador getOneCoordenador(int id) {
		Coordenador coord = repo.findById(id);
		return coord;
	}
	
	public boolean saveCoordenador(Coordenador coord) {
		long count = repo.count();
		repo.save(coord);
		if(count < repo.count()) {
			return true;
		}else {
			return false;
		}
	}
	
	public Coordenador deleteCoordenador(int id) {
		repo.deleteById(id);
		Coordenador coord = repo.findById(id);
		return coord;
	}
 	
	
}
