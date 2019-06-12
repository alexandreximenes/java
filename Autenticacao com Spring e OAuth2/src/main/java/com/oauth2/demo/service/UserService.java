package com.oauth2.demo.service;

import com.oauth2.demo.domain.User;
import com.oauth2.demo.domain.UserDTO;
import com.oauth2.demo.repository.UserRepository;
import com.oauth2.demo.resource.response.I18n;
import com.oauth2.demo.service.exception.BadRequestException;
import com.oauth2.demo.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

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
                .filter(userDTO -> nonNull(userDTO.getEmail()))
                .sorted(Comparator.comparing(UserDTO::getEmail))
                .collect(Collectors.toList());
    }

    public UserDTO findById(String id){
        return Optional.ofNullable(findUserById(id))
                .map(UserDTO::new)
                .get();
    }

    private User findUserById(String id) {
        return userRepository
                .findById(id)
                .orElseThrow( () -> new ObjectNotFoundException(i18n.notFound()));
    }

    public UserDTO save(UserDTO userDTO){
        User userCurrent = modelMapper.map(userDTO, User.class);
        return Optional.ofNullable(userRepository.save(userCurrent))
                .filter(Objects::nonNull)
                .map(UserDTO::new)
                .orElseThrow( () -> new BadRequestException(i18n.notSaved()));
    }


    public UserDTO update(String id, @NonNull UserDTO userDTO) {
        User user = this.findUserById(id);
        userDTO.setId(user.getId());
        if(nonNull(userDTO.getFirstName())) user.setFirstName(userDTO.getFirstName());
        if(nonNull(userDTO.getLastName())) user.setLastName(userDTO.getLastName());
        if(nonNull(userDTO.getEmail())) user.setEmail(userDTO.getEmail());

        return modelMapper.map(userRepository.save(user), UserDTO.class);
    }

    @SneakyThrows(Exception.class)
    public void delete(String id) {
        User userFound = this.findUserById(id);
        userRepository.deleteById(userFound.getId());

    }
}
