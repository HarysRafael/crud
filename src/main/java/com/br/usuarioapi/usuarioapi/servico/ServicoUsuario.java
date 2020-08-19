package com.br.usuarioapi.usuarioapi.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.usuarioapi.usuarioapi.modelo.ModeloUsuario;
import com.br.usuarioapi.usuarioapi.repositorio.RepositorioUsuario;

import java.util.List;


@Service
public class ServicoUsuario {

    private final RepositorioUsuario repositorioUsuario;

    @Autowired
    public ServicoUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;  }


    public ModeloUsuario salvarUsuario(ModeloUsuario modeloUsuario) {
        return repositorioUsuario.save(modeloUsuario);
    }

    public void deletarUsuario(ModeloUsuario modeloUsuario) {
        this.buscarUsuarioId(modeloUsuario.getId());
        repositorioUsuario.delete(modeloUsuario);

    }

    public void deletarId(Long id) {
        this.buscarUsuarioId(id);
        repositorioUsuario.deleteById(id);


    }

    public ModeloUsuario buscarUsuarioId(Long id) {
        return repositorioUsuario.findById(id).get();
    }

    public List<ModeloUsuario> listaUsuarios() {
        return repositorioUsuario.findAll();
    }

    public ModeloUsuario editarUsuario(ModeloUsuario modeloUsuario) {

        if (repositorioUsuario.existsById(modeloUsuario.getId())){

            modeloUsuario.setId(modeloUsuario.getId());
            repositorioUsuario.save(modeloUsuario);
        }
        return modeloUsuario;
    }
}
