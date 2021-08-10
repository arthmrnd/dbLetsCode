package br.com.letscode.dbletscode.controller;

import br.com.letscode.dbletscode.entity.CursoDisciplina;
import br.com.letscode.dbletscode.exception.IAmATeapot;
import br.com.letscode.dbletscode.repository.CursoDisciplinaRepository;
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

@RequestMapping("/cursodisciplina")
@RestController
@RequiredArgsConstructor
public class CursoDisciplinaController {

    private final CursoDisciplinaRepository cursoDisciplinaRepository;

    @GetMapping
    public Iterable<CursoDisciplina> listarTodos() {
        return cursoDisciplinaRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<CursoDisciplina> findById(@PathVariable int id) {
        return cursoDisciplinaRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CursoDisciplina inserirCursoDisciplina(@RequestBody CursoDisciplina cursoDisciplina) {
        return cursoDisciplinaRepository.save(cursoDisciplina);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        if (isExists(id)) cursoDisciplinaRepository.deleteById(id);
    }

    @PatchMapping("/{id}")
    public CursoDisciplina updateCursoDisciplina(@PathVariable int id, @RequestBody CursoDisciplina cd){
        if (isExists(id)) return this.inserirCursoDisciplina(cd);
        else throw new IAmATeapot();
    }

    private boolean isExists(int id) {
        return cursoDisciplinaRepository.existsById(id);
    }
}
