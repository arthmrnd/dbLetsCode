package br.com.letscode.dbletscode.repository;

import br.com.letscode.dbletscode.entity.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Integer> {
}
