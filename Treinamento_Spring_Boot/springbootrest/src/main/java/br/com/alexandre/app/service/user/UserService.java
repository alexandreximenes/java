package br.com.alexandre.app.service.user;

import br.com.alexandre.app.model.User;
import br.com.alexandre.app.model.vo.ResponseVO;
import br.com.alexandre.app.model.vo.UserVO;
import br.com.alexandre.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepository repUser = null;

    public ResponseEntity<?> findAll() {
        List<User> users = (List<User>) repUser.findAll();
        if (users == null) {
            return new ResponseEntity<>(ResponseVO.error("Nenhum usuario encontrado!"), HttpStatus.NO_CONTENT);
        }
        ResponseVO response = ResponseVO.sucess(users.size() +" Usuarios encontrados");
        response.users = UserVO.toList(users);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
