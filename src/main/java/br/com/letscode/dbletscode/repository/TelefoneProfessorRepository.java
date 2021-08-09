package br.com.letscode.dbletscode.repository;

import br.com.letscode.dbletscode.entity.TelefoneProfessor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneProfessorRepository extends CrudRepository<TelefoneProfessor, Integer> {
}
