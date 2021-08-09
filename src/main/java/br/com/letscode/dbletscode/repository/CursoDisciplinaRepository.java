package br.com.letscode.dbletscode.repository;

import br.com.letscode.dbletscode.entity.CursoDisciplina;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoDisciplinaRepository extends CrudRepository<CursoDisciplina, Integer> {
}
