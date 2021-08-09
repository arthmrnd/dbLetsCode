package br.com.letscode.dbletscode.repository;

import br.com.letscode.dbletscode.entity.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Integer> {
}
