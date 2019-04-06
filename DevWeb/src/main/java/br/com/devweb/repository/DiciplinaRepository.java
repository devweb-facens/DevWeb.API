package br.com.devweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.devweb.models.Admin;

public interface DiciplinaRepository extends JpaRepository<Admin, Integer>{

}
