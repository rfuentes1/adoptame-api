package xyz.rociofuentes.adoptameapi.mascota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.rociofuentes.adoptameapi.albergue.Albergue;
import xyz.rociofuentes.adoptameapi.albergue.AlbergueRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MascotaServiceImpl implements MascotaService {
    private final AlbergueRepository albergueRepository;
    private final MascotaRepository mascotaRepository;

    @Autowired
    public MascotaServiceImpl(AlbergueRepository albergueRepository, MascotaRepository mascotaRepository) {
        this.albergueRepository = albergueRepository;
        this.mascotaRepository = mascotaRepository;
    }


    @Override
    public List<MascotaDto> listarMascotas(){
        return mascotaRepository.findAll().stream()
                .map(m -> MascotaUtil.mascotaADto(m)).collect(Collectors.toList());
    }

    @Override
    public Optional<MascotaDto> traerPorId(Long id) {
        return mascotaRepository.findById(id)
                .map(mascota -> MascotaUtil.mascotaADto(mascota));
    }


    @Override
    public MascotaDto agregarMascota(MascotaDto mascotaDto){
        // Convert from Dto to entity
        Mascota mascota = MascotaUtil.dtoAMascota(mascotaDto);
        // get albergueId
        Long idAlbergue = mascota.getAlbergue().getIdAlbergue();
        // retrieve from the database the albergue entity with the previous id
        //  if not found throw an exception
        Albergue albergueDb = albergueRepository.findById(idAlbergue)
                .orElseThrow(() -> new EntityNotFoundException("Id de albergue no enconrado"));
        //if found replace the empty albergue from the one from the repository
        mascota.setAlbergue(albergueDb);
        // return the mascota and the full albergue entity
        return MascotaUtil.mascotaADto(mascotaRepository.save(mascota));
    }

}
