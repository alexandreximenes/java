package br.com.alexandre.app.endpoint;

import br.com.alexandre.app.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserEndpoint {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> all(){
        return userService.findAll();
    }
}
