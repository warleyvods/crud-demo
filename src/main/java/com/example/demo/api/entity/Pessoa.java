package com.example.demo.api.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String cpf;
    private Integer idade;

}
