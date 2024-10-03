package com.learning.cntrls.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="registration")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="age")
    private int age;

    @Column(name="mobile_no")
    private String mobileNo;

    @Column(name="email")
    private String email;

    @ToString.Exclude
    private String password;
}
