package mts.homework.mvc.controller.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mts.homework.mvc.controller.ApplicationController;
import mts.homework.mvc.controller.dto.request.GreetDtoRequest;
import mts.homework.mvc.controller.dto.request.UserDtoRequest;
import mts.homework.mvc.exception.CustomException;
import mts.homework.mvc.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ApplicationControllerImpl implements ApplicationController {
    @Override
    public String getHello() {
        return "Hello, world!";
    }

    @Override
    public String getHelloPersonal(GreetDtoRequest req) {
        return "Hello, " + req.getName() + "!";
    }

    @Override
    public String registerUser(UserDtoRequest req) {
        return "User " + req.getName() + " with email " + req.getEmail() + " was registered";
    }
    @Override
    public String concatParams(String id, String name) {
        return id + " " + name;
    }

    @Override
    public String errorHandler(String name) {
        if (name == null || name.length() == 0) {
            throw new UserNotFoundException("It's a bad name:(");
        }

        return name + " was found";
    }

    @Override
    public String getHeaderParam(String userAgent) {
        return userAgent;
    }

    @Override
    public String customException() {
        throw new CustomException("OOOOPS");
    }

    @Override
    public String checkDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr,formatter);

        return "Good date " + date;
    }

    @Override
    public String defaultValue(String name) {
        return name;
    }
}
