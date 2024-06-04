package com.BookFlow.usuarios.repository;

import com.BookFlow.usuarios.domain.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface usuarioRepository extends JpaRepository<usuario, Long> {
    List<usuario> findByFirstname(String firstname);
    List<usuario> findByLastname(String lastname);
    Optional<usuario> findByEmail(String email);
}
