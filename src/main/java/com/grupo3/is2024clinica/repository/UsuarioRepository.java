//  UsuarioRepository
package com.grupo3.is2024clinica.repository;

import com.grupo3.is2024clinica.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
