package mts.homework.mvc.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
