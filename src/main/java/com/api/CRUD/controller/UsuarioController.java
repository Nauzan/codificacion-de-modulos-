package com.api.CRUD.controller;

import com.api.CRUD.model.Usuario;
import com.api.CRUD.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controlador REST para gestionar usuarios.
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Endpoint para crear un nuevo usuario.
     * @param usuario El usuario a crear.
     * @return El usuario creado.
     */
    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    /**
     * Endpoint para buscar un usuario por su nombre.
     * @param nombre El nombre del usuario a buscar.
     * @return El usuario encontrado o 404 si no existe.
     */
    @GetMapping("/{nombre}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable String nombre) {
        Optional<Usuario> usuarioOpt = usuarioService.buscarPorNombre(nombre);
        if (usuarioOpt.isPresent()) {
            return ResponseEntity.ok(usuarioOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpoint para validar credenciales de un usuario.
     * @param nombre El nombre del usuario.
     * @param contrasena La contraseña ingresada.
     * @return true si las credenciales son correctas, false en caso contrario.
     */
    @PostMapping("/validar")
    public ResponseEntity<Boolean> validarCredenciales(@RequestParam String nombre,
                                                        @RequestParam String contrasena) {
        boolean esValido = usuarioService.validarCredenciales(nombre, contrasena);
        return ResponseEntity.ok(esValido);
    }
}
