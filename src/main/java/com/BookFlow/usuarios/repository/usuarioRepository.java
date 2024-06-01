package com.BookFlow.usuarios.repository;

import com.BookFlow.usuarios.domain.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usuarioRepository extends JpaRepository<usuario, Long> {
}
