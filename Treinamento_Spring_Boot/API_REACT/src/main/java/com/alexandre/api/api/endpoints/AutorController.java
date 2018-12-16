package com.alexandre.api.api.endpoints;

import com.alexandre.api.api.Repository.AutorRepository;
import com.alexandre.api.api.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/livros")
@Transactional
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @GetMapping
    public ResponseEntity<?> all() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping//(consumes = {"application/json"})
    public ResponseEntity<?> save(@Valid @RequestBody Autor autor) {
        repository.save(autor);
        return new ResponseEntity<>(repository.findAllOrderByIdDesc(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Autor autor) {
        Autor autorSaved = repository.save(autor);
        return new ResponseEntity<>(autorSaved, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        repository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
