package com.api.CRUD.service;

import com.api.CRUD.model.Usuario;
import com.api.CRUD.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> obtenerUsuarioPorCredenciales(String nombre, String contrasena) {
        return usuarioRepository.findByNombreAndContrasena(nombre, contrasena);
    }

    public boolean validarCredenciales(String nombre, String contrasena) {
        return usuarioRepository.findByNombreAndContrasena(nombre, contrasena).isPresent();
    }
}

