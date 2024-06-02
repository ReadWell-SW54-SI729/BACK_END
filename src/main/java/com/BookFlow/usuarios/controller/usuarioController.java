package com.BookFlow.usuarios.controller;

import com.BookFlow.usuarios.domain.usuario;
import com.BookFlow.usuarios.service.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class usuarioController {

    @Autowired
    private usuarioService usuarioService;

    @GetMapping
    public List<usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<usuario> getUsuarioById(@PathVariable Long id) {
        Optional<usuario> usuario = usuarioService.findById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createUsuario(@RequestBody usuario usuario) {
        if (usuarioService.emailExists(usuario.getEmail())) {
            return ResponseEntity.status(400).body("Email already registered");
        }
        usuario savedUsuario = usuarioService.save(usuario);
        return ResponseEntity.ok(savedUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<usuario> updateUsuario(@PathVariable Long id, @RequestBody usuario usuarioDetails) {
        Optional<usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent()) {
            usuario existingUsuario = usuario.get();
            existingUsuario.setFirstname(usuarioDetails.getFirstname());
            existingUsuario.setLastname(usuarioDetails.getLastname());
            existingUsuario.setEmail(usuarioDetails.getEmail());
            existingUsuario.setPassword(usuarioDetails.getPassword());
            usuario updatedUsuario = usuarioService.save(existingUsuario);
            return ResponseEntity.ok(updatedUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        if (usuarioService.findById(id).isPresent()) {
            usuarioService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}