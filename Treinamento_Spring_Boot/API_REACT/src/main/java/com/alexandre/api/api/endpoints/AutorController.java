package com.alexandre.api.api.endpoints;

import com.alexandre.api.api.Repository.AutorRepository;
import com.alexandre.api.api.Repository.LivroRepository;
import com.alexandre.api.api.model.Autor;
import com.alexandre.api.api.model.Livro;
import com.alexandre.api.api.model.vo.AutorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AutorController {

    @Autowired
    private AutorRepository autorRep;
    @Autowired
    private LivroRepository livroRep;

    @GetMapping("")
    public ResponseEntity<?> all() {
        return new ResponseEntity<>(autorRep.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody AutorVO autorVO) {
        Autor autor = autorVO.build();
        Autor autorSaved = autorRep.save(autor);
//        for (Livro livro : autor.getLivros()){
//            Livro livro1 = new Livro(livro.getTitulo(), livro.getPreco());
//            livro1.setAutor(autorSaved);
//            livroRep.save(livro1);

//        }
        return new ResponseEntity<>(autorSaved, HttpStatus.OK);
    }
}
