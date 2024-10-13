package com.test.api.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UsersResponse {
    private int id ;
    private String name;
    private String gender;
    private String email;
    private String status;
}
