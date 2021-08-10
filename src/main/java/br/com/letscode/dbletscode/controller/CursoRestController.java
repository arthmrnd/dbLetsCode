package br.com.letscode.dbletscode.controller;

import br.com.letscode.dbletscode.entity.Curso;
import br.com.letscode.dbletscode.exception.IAmATeapot;
import br.com.letscode.dbletscode.repository.CursoRepository;
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

@RequestMapping("/curso")
@RestController
@RequiredArgsConstructor
public class CursoRestController {

    private final CursoRepository cursoRepository;

    @GetMapping
    public Iterable<Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Curso> findById(@PathVariable int id) {
        return cursoRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso inserirCurso(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        if (isExists(id)) cursoRepository.deleteById(id);
    }

    @PatchMapping("/{id}")
    public Curso updateCurso(@PathVariable int id, @RequestBody Curso curso) {
        if (isExists(id)) return this.inserirCurso(curso);
        else throw new IAmATeapot();
    }

    private boolean isExists(int id) {
        return cursoRepository.existsById(id);
    }
}
