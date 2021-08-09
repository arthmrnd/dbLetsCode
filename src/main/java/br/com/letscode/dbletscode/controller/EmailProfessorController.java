package br.com.letscode.dbletscode.controller;

import br.com.letscode.dbletscode.entity.EmailProfessor;
import br.com.letscode.dbletscode.exception.IAmATeapot;
import br.com.letscode.dbletscode.repository.EmailProfessorRepository;
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

@RequestMapping("/emailprofessor")
@RestController
@RequiredArgsConstructor
public class EmailProfessorController {

    private final EmailProfessorRepository emailProfessorRepository;

    @GetMapping
    public Iterable<EmailProfessor> listarTodos() {
        return emailProfessorRepository.findAll();
    }

    @GetMapping("/findbyid")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<EmailProfessor> findById(@RequestParam Integer id) {
        return emailProfessorRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmailProfessor inserirEmail(@RequestBody EmailProfessor emailProfessor){
        return emailProfessorRepository.save(emailProfessor);
    }

    @DeleteMapping
    public void deleteById(@RequestBody Integer id) {
        emailProfessorRepository.deleteById(id);
    }

    @PatchMapping
    public EmailProfessor updateEmail(@RequestBody EmailProfessor email) {
        if (emailProfessorRepository.existsById(email.getId())) {
            this.deleteById(email.getId());
            return this.inserirEmail(email);
        }
        else throw new IAmATeapot();
    }
}
