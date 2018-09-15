package br.com.alexandre.app.endpoint;

import br.com.alexandre.app.CustomMessage.Message;
import br.com.alexandre.app.model.Cursos;
import br.com.alexandre.app.repository.CursosRepository;
import br.com.alexandre.app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursosEndPoint {
/*
    @Autowired
    CursosRepository daoCurso;

    @GetMapping()
    public ResponseEntity<?> lista(){
        return new ResponseEntity<>(daoCurso.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        VerifyIfCursoExists(daoCurso.findById(id));
        Optional<Cursos> curso = daoCurso.findById(id);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<?> addCurso(@RequestBody Cursos curso){
        daoCurso.save(curso);
        return new ResponseEntity<>(new Message("save"), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> updateCurso(@RequestBody Cursos curso){
        VerifyIfCursoExists(Optional.ofNullable(curso));
        daoCurso.save(curso);
        return new ResponseEntity(new Message("update"), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCurso(@PathVariable("id") Long id){
        VerifyIfCursoExists(daoCurso.findById(id));
        daoCurso.deleteById(id);
        return new ResponseEntity(new Message("delete"), HttpStatus.OK);

    }

    private void VerifyIfCursoExists(Optional<Cursos> curso) {

        Optional<Cursos> responseCurso = daoCurso.findById(curso.get().getId());
        if(responseCurso == null) throw new RuntimeException("Curso não existe na base de dados");
    }
*/}
