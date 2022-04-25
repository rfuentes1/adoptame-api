package xyz.rociofuentes.adoptameapi.mascota;

import java.util.List;
import java.util.Optional;

public interface MascotaService {
    List<Mascota> listarMascotas();
    Optional<Mascota> traerPorId(Long id);
    Mascota agregarMascota(Mascota mascota);
}
