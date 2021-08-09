package br.com.letscode.dbletscode.controller;

import br.com.letscode.dbletscode.entity.Disciplina;
import br.com.letscode.dbletscode.exception.IAmATeapot;
import br.com.letscode.dbletscode.repository.DisciplinaRepository;
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

@RequestMapping("/disciplina")
@RestController
@RequiredArgsConstructor
public class DisciplinaRestController {

    private final DisciplinaRepository disciplinaRepository;

    @GetMapping
    public Iterable<Disciplina> listarTodos() {
        return disciplinaRepository.findAll();
    }

    @GetMapping("/findbyid")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Disciplina> findById(@RequestParam String id) {
        return disciplinaRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Disciplina inserirDisciplina(@RequestBody Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    @DeleteMapping
    public void deleteById(@RequestBody String id) {
        disciplinaRepository.deleteById(id);
    }

    @PatchMapping
    public Disciplina updateDisciplina(@RequestBody Disciplina disciplina) {
        if (disciplinaRepository.existsById(disciplina.getCodigoDisciplina())) {
            this.deleteById(disciplina.getCodigoDisciplina());
            return this.inserirDisciplina(disciplina);
        }
        else throw new IAmATeapot();
    }
}
