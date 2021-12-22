package service.cafe.advice.exceptions;

import javassist.NotFoundException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends NotFoundException {

    @Getter
    HttpStatus status = HttpStatus.NOT_FOUND;

    public UserNotFoundException() {
        super("해당 사용자 정보가 없습니다.");
    }

}
