package xyz.rociofuentes.adoptameapi.mascota;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


//mágicamente me da la implementacion para traer la lista de las mascotas
@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    List<Mascota> findByDisponible(boolean estaDisponible);
}
