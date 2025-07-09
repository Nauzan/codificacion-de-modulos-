package com.api.CRUD.repository;

import com.api.CRUD.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombre(String nombre); // ✅ ESTE ES CLAVE
    Optional<Usuario> findByNombreAndContrasena(String nombre, String contrasena);
}

