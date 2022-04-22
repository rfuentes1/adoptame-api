package xyz.rociofuentes.adoptameapi.mascota;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//mágicamente me da la implementacion para traer la lista de las mascotas
@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {

}
