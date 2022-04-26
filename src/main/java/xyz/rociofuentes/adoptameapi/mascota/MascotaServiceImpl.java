package xyz.rociofuentes.adoptameapi.mascota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.rociofuentes.adoptameapi.albergue.Albergue;
import xyz.rociofuentes.adoptameapi.albergue.AlbergueService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;
    private final AlbergueService albergueService;

    @Autowired
    public MascotaServiceImpl(MascotaRepository mascotaRepository, AlbergueService albergueService) {
        this.mascotaRepository = mascotaRepository;
        this.albergueService = albergueService;
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
        Optional<Albergue> albergue = albergueService.traerAlberguePorId(idAlbergue);
        if (albergue.isPresent()){
            mascota.setAlbergue(albergue.get());
            return mascotaRepository.save(mascota);
        }
        throw new EntityNotFoundException("Albergue no encontrado");
    }
}
