package com.test.api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "set")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Users {
    private String name;
    private String gender;
    private String email;
    private String status;
}
