package br.com.devweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.devweb.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
