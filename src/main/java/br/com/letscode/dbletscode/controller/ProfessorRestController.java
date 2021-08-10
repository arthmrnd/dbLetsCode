package br.com.letscode.dbletscode.controller;

import br.com.letscode.dbletscode.entity.Professor;
import br.com.letscode.dbletscode.exception.IAmATeapot;
import br.com.letscode.dbletscode.repository.ProfessorRepository;
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

@RequestMapping("/professor")
@RestController
@RequiredArgsConstructor
public class ProfessorRestController {

    private final ProfessorRepository professorRepository;

    @GetMapping
    public Iterable<Professor> listarTodos() {
        return professorRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Professor> findById(@PathVariable int id) {
        return professorRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Professor inserirProfessor(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        if (isExists(id)) professorRepository.deleteById(id);
    }

    @PatchMapping("/{id}")
    public Professor updateProfessor(@PathVariable int id, @RequestBody Professor professor) {
        if (isExists(id)) return this.inserirProfessor(professor);
        else throw new IAmATeapot();
    }

    private boolean isExists(int id) {
        return professorRepository.existsById(id);
    }
}
