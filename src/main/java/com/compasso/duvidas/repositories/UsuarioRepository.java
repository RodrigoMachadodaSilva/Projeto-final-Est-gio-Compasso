package com.compasso.duvidas.repositories;


import com.compasso.duvidas.entities.Usuario;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Page<Usuario> findByNome(Pageable page, String nome);
    
    Optional<Usuario> findByEmail(String email);
}
