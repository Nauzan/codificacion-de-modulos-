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
@CrossOrigin(origins = "http://localhost:5173") // Solo una vez aquí
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Crear usuario
    @PostMapping
    public ResponseEntity<String> registroUsuario(@RequestBody Usuario usuario) {
        usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok("✅ Registro exitoso");
    }

    // Validar con @RequestParam (query params)
    @PostMapping("/validar")
    public ResponseEntity<String> validarConQueryParams(@RequestParam String nombre,
                                                        @RequestParam String contrasena) {
        boolean esValido = usuarioService.validarCredenciales(nombre, contrasena);

        if (esValido) {
            return ResponseEntity.ok("✅ Login exitoso (query params)");
        } else {
            return ResponseEntity.status(401).body("❌ Credenciales inválidas");
        }
    }

    // Validar con @RequestBody (JSON)
    @PostMapping("/validar-json")
    public ResponseEntity<String> validarConJson(@RequestBody Usuario usuario) {
        boolean esValido = usuarioService.validarCredenciales(usuario.getNombre(), usuario.getContrasena());

        if (esValido) {
            return ResponseEntity.ok("✅ Login exitoso (JSON)");
        } else {
            return ResponseEntity.status(401).body("❌ Credenciales inválidas");
        }
    }
}
