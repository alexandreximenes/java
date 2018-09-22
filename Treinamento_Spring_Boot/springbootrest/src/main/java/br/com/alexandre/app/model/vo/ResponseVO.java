package br.com.alexandre.app.model.vo;

import br.com.alexandre.app.model.User;

import java.util.ArrayList;
import java.util.List;

public class ResponseVO {

    public String code;
    public String message;

    public List<UserVO> users = new ArrayList<>();
    public User user;

    public ResponseVO() {
    }

    public ResponseVO(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResponseVO error(String message) {
        return new ResponseVO("ERROR", message);
    }

    public static ResponseVO error(String code, String message) {
        return new ResponseVO(code, message);
    }

    public static ResponseVO sucess(String message) {
        return new ResponseVO("SUCESS", message);
    }
}
