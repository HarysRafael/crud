package com.br.usuarioapi.usuarioapi.controller;

import com.br.usuarioapi.usuarioapi.modelo.ModeloUsuario;
import com.br.usuarioapi.usuarioapi.servico.ServicoUsuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/test")
public class ControllerUsuario {

    private final ServicoUsuario servicoUsuario;
    private final ModelMapper modelMapper;

    @Autowired
    public ControllerUsuario(ServicoUsuario servicoUsuario, ModelMapper modelMapper) {

        this.servicoUsuario = servicoUsuario;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public RespostaCadastroDTO cadastrar(@RequestBody CadastroDTO cadastroDTO){
        ModeloUsuario modeloUsuario = modelMapper.map(cadastroDTO, ModeloUsuario.class);
       ModeloUsuario usuario = servicoUsuario.salvarUsuario(modeloUsuario);
        return modelMapper.map(usuario, RespostaCadastroDTO.class);

    }

    @GetMapping()
    public List<RespostaCadastroDTO> listaController(){
        List<ModeloUsuario> modeloUsuario = servicoUsuario.listaUsuarios();
        List<RespostaCadastroDTO> resposta = new ArrayList<>();
        for(ModeloUsuario usuario: modeloUsuario){
            resposta.add(modelMapper.map(modeloUsuario, RespostaCadastroDTO.class));
        }
        return resposta;
    }

    @GetMapping("/{id}")
    public RespostaCadastroDTO buscarUsuario(@PathVariable Long id){
        ModeloUsuario modeloUsuario = servicoUsuario.buscarUsuarioId(id);
        return modelMapper.map(modeloUsuario, RespostaCadastroDTO.class);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable long id){
        servicoUsuario.deletarId(id);

    }


}
