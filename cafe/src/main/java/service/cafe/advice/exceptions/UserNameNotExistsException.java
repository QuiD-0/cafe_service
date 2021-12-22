package service.cafe.advice.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class UserNameNotExistsException extends Exception {

    @Getter
    HttpStatus status = HttpStatus.BAD_REQUEST;

    public UserNameNotExistsException() {
        super("사용자 정보가 부족합니다.");
    }

}
