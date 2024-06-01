package com.BookFlow.usuarios.service;

import com.BookFlow.usuarios.domain.usuario;
import com.BookFlow.usuarios.repository.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class usuarioService {

    @Autowired
    private usuarioRepository usuarioRepository;

    public List<usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public usuario save(usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}
