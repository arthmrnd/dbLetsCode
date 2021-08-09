package br.com.letscode.dbletscode.controller;

import br.com.letscode.dbletscode.entity.CursoDisciplina;
import br.com.letscode.dbletscode.exception.IAmATeapot;
import br.com.letscode.dbletscode.repository.CursoDisciplinaRepository;
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

@RequestMapping("/cursodisciplina")
@RestController
@RequiredArgsConstructor
public class CursoDisciplinaController {

    private final CursoDisciplinaRepository cursoDisciplinaRepository;

    @GetMapping
    public Iterable<CursoDisciplina> listarTodos() {
        return cursoDisciplinaRepository.findAll();
    }

    @GetMapping("/findbyid")
    public Optional<CursoDisciplina> findById(@RequestParam Integer id) {
        return cursoDisciplinaRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.FOUND)
    public CursoDisciplina inserirCursoDisciplina(@RequestBody CursoDisciplina cursoDisciplina) {
        return cursoDisciplinaRepository.save(cursoDisciplina);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void deleteById(@RequestBody Integer id) {
        cursoDisciplinaRepository.deleteById(id);
    }

    @PatchMapping
    public CursoDisciplina updateCursoDisciplina(@RequestBody CursoDisciplina cd){
        if (cursoDisciplinaRepository.existsById(cd.getId())){
            this.deleteById(cd.getId());
            return this.inserirCursoDisciplina(cd);
        }
        else throw new IAmATeapot();
    }
}
