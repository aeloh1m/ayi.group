package com.demorest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demorest.Modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
