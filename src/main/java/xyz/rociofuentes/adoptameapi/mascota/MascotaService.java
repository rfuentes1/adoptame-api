package xyz.rociofuentes.adoptameapi.mascota;

import java.util.List;
import java.util.Optional;

public interface MascotaService {
    List<MascotaDto> listarMascotas();
    Optional<MascotaDto> traerPorId(Long id);
    MascotaDto agregarMascota(MascotaDto mascota);
    void marcarNoDisponible(Long id);
}
