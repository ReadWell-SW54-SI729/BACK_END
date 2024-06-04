package com.BookFlow.usuarios.controller;

import com.BookFlow.usuarios.domain.usuario;
import com.BookFlow.usuarios.repository.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class usuarioController {

    @Autowired
    private usuarioRepository usuarioRepository;

    @GetMapping
    public List<usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<usuario> getUsuarioById(@PathVariable Long id) {
        Optional<usuario> usuario = usuarioRepository.findById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> addUsuario(
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String email,
            @RequestParam String password) {
        Optional<usuario> existingUsuario = usuarioRepository.findByEmail(email);

        if (existingUsuario.isPresent()) {
            return ResponseEntity.badRequest().body("El email ya está registrado");
        }

        usuario usuario = new usuario();
        usuario.setFirstname(firstname);
        usuario.setLastname(lastname);
        usuario.setEmail(email);
        usuario.setPassword(password);

        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario creado exitosamente");
    }
}