package mts.homework.mvc.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDtoRequest {
    @NotBlank
    @Length(min = 1, max = 50)
    @JsonProperty(value = "name", required = true)
    private String name;

    @NotBlank
    @Length(min = 5, max = 100)
    @Pattern(regexp = ".+@.+\\..+")
    @JsonProperty(value = "email", required = true)
    private String email;
}
