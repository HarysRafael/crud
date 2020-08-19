package com.br.usuarioapi.usuarioapi.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.usuarioapi.usuarioapi.modelo.ModeloUsuario;

@Repository
public interface RepositorioUsuario extends JpaRepository <ModeloUsuario, Long>{





}
