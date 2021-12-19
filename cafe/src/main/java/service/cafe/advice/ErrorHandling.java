package service.cafe.advice;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandling {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse exception(final CustomException e) {
        final ErrorResponse response = new ErrorResponse(e.getMessage(), 400);
        return response;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse notFount(final Exception e) {
        final ErrorResponse response = new ErrorResponse(e.getMessage(), 400);
        return response;
    }

}
