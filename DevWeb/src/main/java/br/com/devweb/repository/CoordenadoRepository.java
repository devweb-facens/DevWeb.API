package br.com.devweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.devweb.models.Coordenado;

public interface CoordenadoRepository extends JpaRepository<Coordenado, Integer>{

}
