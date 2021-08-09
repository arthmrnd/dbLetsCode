package br.com.letscode.dbletscode.repository;

import br.com.letscode.dbletscode.entity.Disciplina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends CrudRepository<Disciplina, String> {
}
