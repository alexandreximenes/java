package com.oauth2.demo.resource;

import com.oauth2.demo.domain.UserDTO;
import com.oauth2.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserResouce {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        List<UserDTO> all = userService.findAll();
        if (nonNull(all))
            return ResponseEntity.ok().body(all);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") String id) {
        UserDTO userDTO = userService.findById(id);
        return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody UserDTO userDTO) {
        UserDTO userSaved = userService.save(userDTO);
        return ResponseEntity.created().build();

    }
}
