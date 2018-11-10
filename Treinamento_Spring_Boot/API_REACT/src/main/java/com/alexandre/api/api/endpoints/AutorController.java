package com.alexandre.api.api.endpoints;

import com.alexandre.api.api.Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AutorController {

    @Autowired
    private AutorRepository rep;

    @GetMapping("")
    public ResponseEntity <?> all(){
        return new ResponseEntity<>(rep.findAll(), HttpStatus.OK);
    }
}
