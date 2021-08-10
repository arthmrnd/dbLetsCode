package br.com.letscode.dbletscode.controller;

import br.com.letscode.dbletscode.entity.Disciplina;
import br.com.letscode.dbletscode.exception.IAmATeapot;
import br.com.letscode.dbletscode.repository.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/disciplina")
@RestController
@RequiredArgsConstructor
public class DisciplinaRestController {

    private final DisciplinaRepository disciplinaRepository;

    @GetMapping
    public Iterable<Disciplina> listarTodos() {
        return disciplinaRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Disciplina> findById(@PathVariable String id) {
        return disciplinaRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Disciplina inserirDisciplina(@RequestBody Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        if (isExists(id)) disciplinaRepository.deleteById(id);
    }

    @PatchMapping("/{id}")
    public Disciplina updateDisciplina(@PathVariable String id, @RequestBody Disciplina disciplina) {
        if (isExists(id)) return this.inserirDisciplina(disciplina);
        else throw new IAmATeapot();
    }

    private boolean isExists(String id) {
        return disciplinaRepository.existsById(id);
    }
}
