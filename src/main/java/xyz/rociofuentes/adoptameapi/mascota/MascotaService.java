package xyz.rociofuentes.adoptameapi.mascota;

import java.util.List;
import java.util.Optional;

public interface MascotaService {
    List<MascotaDto> listarMascotas();
    Optional<MascotaDto> traerPorId(Long id);
    MascotaDto agregarOEditarMascota(MascotaDto mascota);
    void marcarNoDisponible(Long id);
    List<MascotaDto> listarMascotasDisponibles();
}