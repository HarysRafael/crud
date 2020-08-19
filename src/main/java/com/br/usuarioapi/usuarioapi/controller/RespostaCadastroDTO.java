package com.br.usuarioapi.usuarioapi.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespostaCadastroDTO {

    private Long id;
    private String email;
    private String nome;

}
