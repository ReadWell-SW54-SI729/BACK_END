package com.BookFlow.usuarios.domain;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String email;
    private String password;
}
