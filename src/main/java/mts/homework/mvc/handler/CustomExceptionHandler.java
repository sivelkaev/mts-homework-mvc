package mts.homework.mvc.handler;

import mts.homework.mvc.exception.CustomException;
import mts.homework.mvc.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.DateTimeException;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFoundExceptionHandler(UserNotFoundException e) {
        return "You have UserNotFoundException: " + e.getMessage();
    }

    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String customExceptionHandler(CustomException e) {
        return "You have CustomException with 404 code: " + e.getMessage();
    }

    @ExceptionHandler(DateTimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String dateTimeExceptionHandler(DateTimeException e) {
        return "Incorrect format of date: " + e.getMessage();
    }
}
