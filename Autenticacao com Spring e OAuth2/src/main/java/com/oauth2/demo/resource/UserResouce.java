package com.oauth2.demo.resource;

import com.oauth2.demo.domain.UserDTO;
import com.oauth2.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Optional<UserDTO> user = userService.findById();
        if (user.isPresent())
            return ResponseEntity.ok().body(user);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
