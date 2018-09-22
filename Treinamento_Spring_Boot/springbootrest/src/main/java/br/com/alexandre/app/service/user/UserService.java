package br.com.alexandre.app.service.user;

import br.com.alexandre.app.model.User;
import br.com.alexandre.app.model.vo.ResponseVO;
import br.com.alexandre.app.model.vo.UserVO;
import br.com.alexandre.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepository repUser = null;
    private ResponseVO response = null;

    public ResponseEntity<?> findAll() {
        List<User> users = (List<User>) repUser.findAll();
        response = new ResponseVO();
        if (users == null) {
            response = ResponseVO.error("Nenhum usuario encontrado!");
            response.users = new ArrayList<>();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response = ResponseVO.sucess(users.size() +" Usuarios encontrados");
        response.users = UserVO.toList(users);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<?> findByUserName(String username){
        response = new ResponseVO();
        User user = repUser.findByUsernameIgnoreCaseContaining(username);
        if(user == null){
            response = ResponseVO.error("Usuário não encontrado");
            response.user = new User();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response = ResponseVO.sucess("Usuário(a) encontrado(a)");
        response.user = user;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
