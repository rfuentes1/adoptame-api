package xyz.rociofuentes.adoptameapi.albergue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbergueRepository extends JpaRepository<Albergue, Long> {

}
