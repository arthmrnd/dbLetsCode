package br.com.letscode.dbletscode.controller;

import br.com.letscode.dbletscode.entity.Aluno;
import br.com.letscode.dbletscode.exception.IAmATeapot;
import br.com.letscode.dbletscode.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/findbyid")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Aluno> findById(@RequestParam int id) {
        return alunoRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno inserirAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Integer id) {
        alunoRepository.deleteById(id);
    }

    @PatchMapping
    public Aluno updateAluno(@RequestBody Aluno aluno){
        if (alunoRepository.existsById(aluno.getRa())){
            this.deleteById(aluno.getRa());
            return this.inserirAluno(aluno);
        }
        else throw new IAmATeapot();
    }
}
