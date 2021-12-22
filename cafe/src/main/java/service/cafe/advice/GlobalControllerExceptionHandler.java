package service.cafe.advice;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import service.cafe.advice.exceptions.UserNameNotExistsException;
import service.cafe.advice.exceptions.UserNotFoundException;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(UserNameNotExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse exception(final UserNameNotExistsException e) {
        final ErrorResponse response = new ErrorResponse(e.getMessage(), e.getStatus());
        return response;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse notFount(final UserNotFoundException e) {
        final ErrorResponse response = new ErrorResponse(e.getMessage(), e.getStatus());
        return response;
    }

}
