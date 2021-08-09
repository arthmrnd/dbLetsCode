package br.com.letscode.dbletscode.repository;

import br.com.letscode.dbletscode.entity.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Integer> {
}
