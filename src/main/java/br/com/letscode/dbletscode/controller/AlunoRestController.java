package br.com.letscode.dbletscode.controller;

import br.com.letscode.dbletscode.entity.Aluno;
import br.com.letscode.dbletscode.exception.IAmATeapot;
import br.com.letscode.dbletscode.repository.AlunoRepository;
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

@RequestMapping("/aluno")
@RestController
@RequiredArgsConstructor
public class AlunoRestController {

    private final AlunoRepository alunoRepository;

    @GetMapping
    public Iterable<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    @GetMapping("/{ra}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Aluno> findById(@PathVariable int ra) {
        return alunoRepository.findById(ra);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno inserirAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @DeleteMapping("/{ra}")
    public void deleteById(@PathVariable int ra) {
        if (this.alunoExiste(ra)) alunoRepository.deleteById(ra);
    }

    @PatchMapping("/{ra}")
    public Aluno updateAluno(@PathVariable int ra, @RequestBody Aluno aluno){
        if (this.alunoExiste(ra)) return this.inserirAluno(aluno);
        else throw new IAmATeapot();
    }

    private Boolean alunoExiste(int ra) {
        return alunoRepository.existsById(ra);
    }
}
