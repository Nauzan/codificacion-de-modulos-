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

    public Optional<Usuario> buscarPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }

    public boolean validarCredenciales(String nombre, String contrasena) {
        Optional<Usuario> usuario = usuarioRepository.findByNombre(nombre);
        return usuario.isPresent() && usuario.get().getContrasena().equals(contrasena);
    }
}
