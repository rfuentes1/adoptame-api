package xyz.rociofuentes.adoptameapi.mascota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.rociofuentes.adoptameapi.albergue.Albergue;
import xyz.rociofuentes.adoptameapi.albergue.AlbergueRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;
    private final AlbergueRepository albergueRepository;

    @Autowired
    public MascotaServiceImpl(MascotaRepository mascotaRepository, AlbergueRepository albergueRepository) {
        this.mascotaRepository = mascotaRepository;
        this.albergueRepository = albergueRepository;
    }

    @Override
    public List<Mascota> listarMascotas(){
        return mascotaRepository.findAll();
    }

    @Override
    public Optional<Mascota> traerPorId(Long id) {
        return mascotaRepository.findById(id);
    }

    @Override
    public Mascota agregarMascota(Mascota mascota){
        long idAlbergue = mascota.getAlbergue().getIdAlbergue();
        Optional<Albergue> albergue = albergueRepository.findById(idAlbergue);
        if (albergue.isPresent()){
            mascota.setAlbergue(albergue.get());
            return mascotaRepository.save(mascota);
        }
        throw new EntityNotFoundException("Albergue no encontrado");
    }
}
