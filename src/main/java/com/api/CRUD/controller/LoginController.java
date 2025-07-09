package com.api.CRUD.controller;

import com.api.CRUD.model.Usuario;
import com.api.CRUD.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin(origins = "http://localhost:5173")


@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
public ResponseEntity<Usuario> login(@RequestParam String nombre, @RequestParam String contrasena) {
    return usuarioService.obtenerUsuarioPorCredenciales(nombre, contrasena)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
}

