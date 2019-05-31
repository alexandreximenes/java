package com.mongodbwithspring.demo.services;

import com.mongodbwithspring.demo.domain.post.Post;
import com.mongodbwithspring.demo.domain.post.PostDTO;
import com.mongodbwithspring.demo.domain.user.UserObject;
import com.mongodbwithspring.demo.domain.user.UserObjectDTO;
import com.mongodbwithspring.demo.exceptions.ObjectNotFoundException;
import com.mongodbwithspring.demo.repositories.PostRepository;
import com.mongodbwithspring.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<PostDTO> findAll() {
        return postRepository.findAll()
                .parallelStream()
                .filter(Objects::nonNull)
                .map(PostDTO::new)
                .sorted(Comparator.comparing(PostDTO::getTitle))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO findById(String id) {
        return postRepository
                .findById(id)
                .map(PostDTO::new)
                .orElseThrow( () -> new ObjectNotFoundException("Usuario não encontrado"));
    }

    @Override
    public PostDTO save(PostDTO post) {
        return null;
    }

    @Override
    public void update(String id, PostDTO post) {

    }

    @Override
    public void delete(String id) {

    }

//    @Override
//    public Post save(Post post) {
//        Post posts = new Post(post);
//        return new Post(postRepository.save(Post));
//    }
//
//    @Override
//    public void update(String id, Post post) {
//        Post post = postRepository
//                .findById(id)
//                .orElseThrow(() -> new ObjectNotFoundException("Posts não encontrado com ID: " + id));
//        post.set(user.getNome());
//        userObject.setEmail(user.getEmail());
//        postRepository.save(userObject);
//    }
//
//    @Override
//    public void delete(String id) {
//        postRepository.deleteById(id);
//    }

}
