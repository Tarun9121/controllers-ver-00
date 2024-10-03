package com.learning.cntrls.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;

@Data @NoArgsConstructor @AllArgsConstructor
@ToString(exclude = "password")
@Builder
public class RegisterDTO {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String mobileNo;
    private String email;
    @JsonIgnore
    private String password;
}
