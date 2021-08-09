package br.com.letscode.dbletscode.repository;

import br.com.letscode.dbletscode.entity.EmailProfessor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailProfessorRepository extends CrudRepository<EmailProfessor, Integer> {
}
