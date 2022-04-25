package xyz.rociofuentes.adoptameapi.albergue;

import java.util.List;
import java.util.Optional;

public interface AlbergueService {
    List<Albergue> listarAlbergues();
    Optional<Albergue> traerAlberguePorId(Long id);
    Optional<Albergue> traerAlberguePorCorreo(String correo);
}
