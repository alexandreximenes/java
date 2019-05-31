package com.mongodbwithspring.demo.services;

import com.mongodbwithspring.demo.domain.user.UserObject;
import com.mongodbwithspring.demo.domain.user.UserObjectDTO;
import com.mongodbwithspring.demo.exceptions.ObjectNotFoundException;
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
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserObjectDTO> findAll() {
        return userRepository.findAll()
                .parallelStream()
                .filter(Objects::nonNull)
                .map(UserObjectDTO::new)
                .sorted(Comparator.comparing(UserObjectDTO::getNome))
                .collect(Collectors.toList());
    }

    @Override
    public UserObjectDTO findById(String id) {
        UserObjectDTO userObjectDTO = null;
        return userRepository
                .findById(id)
                .map(UserObjectDTO::new)
                .orElseThrow( () -> new ObjectNotFoundException("Usuario não encontrado"));
    }

    @Override
    public UserObjectDTO save(UserObjectDTO user) {
        UserObject userObject = new UserObject(user);
        return new UserObjectDTO(userRepository.save(userObject));
    }

    @Override
    public void update(String id, UserObjectDTO user) {
        UserObject userObject = userRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado com ID: " + id));
        userObject.setNome(user.getNome());
        userObject.setEmail(user.getEmail());
        userRepository.save(userObject);
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }
}
