package xyz.rociofuentes.adoptameapi.albergue;

import java.util.List;
import java.util.Optional;

public interface AlbergueService {
    List<AlbergueDto> listarAlbergues();
    Optional<AlbergueDto> traerAlberguePorId(Long id);
    Optional<AlbergueDto> traerAlberguePorCorreo(String correo);
    AlbergueDto agregarOEditarAlbergue(AlbergueDto albergueDto);

}
