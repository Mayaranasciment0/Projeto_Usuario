package com.example.demo.model;

import java.util.*;

import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Usuario {

    @Column
    private String nomeUsuario;

    @Column
    private String email;

    @Column
    private String senha;

    @Column
    private String bio;

    @Column
    private String contato;

    @Column
    private String localizacao;

    // @Column
    // private ArrayList<Avaliacao> avaliacao;

    @Column
    private byte fotoPerfil;

}