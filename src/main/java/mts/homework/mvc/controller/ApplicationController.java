package mts.homework.mvc.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import mts.homework.mvc.controller.dto.request.GreetDtoRequest;
import mts.homework.mvc.controller.dto.request.UserDtoRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Validated
@RequestMapping(value = "mts-homework-mvc")//, produces = MediaType.APPLICATION_JSON_VALUE)
public interface ApplicationController {
    @GetMapping(value = "/hello")
    String getHello();

    @PostMapping(value = "/greet")
    String getHelloPersonal(@RequestBody GreetDtoRequest req);

    @PostMapping(value = "/user")
    String registerUser(@RequestBody @Valid UserDtoRequest req);

    @GetMapping(value = "/concat-params/{id}")
    @Parameter(name = "name", in = ParameterIn.QUERY, schema = @Schema(type = "string"), required = true)
    String concatParams(@PathVariable(value = "id") @NotBlank String id,
                        @RequestParam(value = "name") @NotBlank String name);

    @GetMapping(value = "/error-handler")
    String errorHandler(@RequestParam(value = "name") String name);

    @GetMapping(value = "/header-params")
    @Parameter(name = HttpHeaders.USER_AGENT, in = ParameterIn.HEADER, required = true)
    String getHeaderParam(@RequestHeader(HttpHeaders.USER_AGENT) @NotEmpty String userAgent);

    @GetMapping(value = "/custom-exception")
    String customException();

    @GetMapping(value = "/date-check/{date:\\d{4}-\\d{2}-\\d{2}}")
    @Parameter(name = "date", in = ParameterIn.QUERY, schema = @Schema(type = "string"), required = true)
    String checkDate(@PathVariable(value = "date") @NotBlank String date);

    @GetMapping(value = "/default-value")
    String defaultValue(@RequestParam(value = "name", defaultValue = "Guest") @NotBlank String name);
}
