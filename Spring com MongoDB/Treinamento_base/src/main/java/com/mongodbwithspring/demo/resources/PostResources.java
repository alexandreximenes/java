package com.mongodbwithspring.demo.resources;

import com.mongodbwithspring.demo.domain.user.UserObjectDTO;
import com.mongodbwithspring.demo.services.PostService;
import com.mongodbwithspring.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//https://www.getpostman.com/collections/113fe058a51517a73087
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/posts")
public class PostResources implements ApiResources{

    @Autowired
    private final PostService postService;

//    @GetMapping
//    @Override
//    public ResponseEntity<Object> findAll() {
//        return ResponseEntity.ok().body(userService.findAll()); //return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<Object> save(@RequestBody UserObjectDTO user) {
//        return ResponseEntity
//                .created(ServletUriComponentsBuilder
//                        .fromCurrentRequest()
//                        .path("/{id}")
//                        .buildAndExpand(userService.save(user).getId()).toUri())
//                .build();
//    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Object> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(postService.findById(id));
    }

//    @DeleteMapping("/{id}")
//    @Override
//    public ResponseEntity<Object> deleteById(@PathVariable("id") String id) {
//        userService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Object> update(@PathVariable("id") String id, @RequestBody UserObjectDTO user) {
//        userService.update(id, user);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/{id}/posts")
//    public ResponseEntity<Object> findByPosts(@PathVariable("id") String id) {
//        return ResponseEntity.ok().body(userService.findByIdPosts(id));
//    }
}
