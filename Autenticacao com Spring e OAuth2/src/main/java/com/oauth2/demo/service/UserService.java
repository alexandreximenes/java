package com.oauth2.demo.service;

import com.oauth2.demo.domain.User;
import com.oauth2.demo.domain.UserDTO;
import com.oauth2.demo.repository.UserRepository;
import com.oauth2.demo.resource.response.I18n;
import com.oauth2.demo.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserRepository userRepository;
    private final I18n i18n;
    private final ModelMapper modelMapper;

    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .parallelStream()
                .filter(Objects::nonNull)
                .map(UserDTO::new)
                .sorted(Comparator.comparing(UserDTO::getEmail))
                .collect(Collectors.toList());
    }

    public UserDTO findById(String id){
        return userRepository.findById(id)
                .filter(Objects::nonNull)
                .map(UserDTO::new)
                .orElseThrow( () -> new ObjectNotFoundException(i18n.notFound()));
    }

    public UserDTO save(UserDTO userDTO){
        User userCurrent = modelMapper.map(userDTO, User.class);
        return Optional.ofNullable(userRepository.save(userCurrent))
                .filter(Objects::nonNull)
                .map(UserDTO::new)
                .orElseThrow( () -> new ObjectNotFoundException("object.not.found"));
    }

}
