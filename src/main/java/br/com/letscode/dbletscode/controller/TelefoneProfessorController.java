package br.com.letscode.dbletscode.controller;

import br.com.letscode.dbletscode.entity.TelefoneProfessor;
import br.com.letscode.dbletscode.exception.IAmATeapot;
import br.com.letscode.dbletscode.repository.TelefoneProfessorRepository;
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

@RequestMapping("/telefoneprofessor")
@RestController
@RequiredArgsConstructor
public class TelefoneProfessorController {

    private final TelefoneProfessorRepository telefoneProfessorRepository;

    @GetMapping
    public Iterable<TelefoneProfessor> listarTodos() {
        return telefoneProfessorRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<TelefoneProfessor> findById(@PathVariable int id) {
        return telefoneProfessorRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TelefoneProfessor inserirEmail(@RequestBody TelefoneProfessor telefoneProfessor){
        return telefoneProfessorRepository.save(telefoneProfessor);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        if (isExists(id)) telefoneProfessorRepository.deleteById(id);
    }

    @PatchMapping("/{id}")
    public TelefoneProfessor updateEmail(@PathVariable int id, @RequestBody TelefoneProfessor telefoneProfessor) {
        if (isExists(id)) return this.inserirEmail(telefoneProfessor);
        else throw new IAmATeapot();
    }

    private boolean isExists(int id) {
        return telefoneProfessorRepository.existsById(id);
    }
}