package xyz.rociofuentes.adoptameapi.albergue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbergueRepository extends JpaRepository<Albergue, Long> {
    Optional<Albergue> findByUsuario_Correo(String correo);
}
