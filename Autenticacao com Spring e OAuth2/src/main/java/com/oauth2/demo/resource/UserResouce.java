package com.oauth2.demo.resource;

import com.oauth2.demo.domain.Role;
import com.oauth2.demo.domain.UserDTO;
import com.oauth2.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
    public Resource<UserDTO> save(@Valid @RequestBody UserDTO userDTO) {
        UserDTO userSaved = userService.save(userDTO);
        return getUriResource(userSaved);
        //OR ResponseEntity.created(URI.create("/users/"+userSaved.getId())).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") String id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public Resource<UserDTO> update(@NonNull @PathVariable("id") String id, @Valid @NonNull @RequestBody UserDTO userDTO) {
        UserDTO userSaved = userService.update(id, userDTO);
        return getUriResource(userSaved);
    }

    @GetMapping("/{id}/roles")
    public ResponseEntity<List<Role>> findRoles(@PathVariable("id") String id) {
        UserDTO userDTO = userService.findById(id);
        return ResponseEntity.ok().body(userDTO.getRoles());
    }

    private Resource<UserDTO> getUriResource(UserDTO userSaved) {
        Resource<UserDTO> resource = new Resource<>(userSaved);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findById(userSaved.getId()));
        resource.add(linkTo.withSelfRel());
//        resource.add(linkTo.withRel("api/users/"+resource.getContent().getId()));
//        resource.add(new Link("/api/users/{id}", "endpoint"));
        return resource;
    }
}
