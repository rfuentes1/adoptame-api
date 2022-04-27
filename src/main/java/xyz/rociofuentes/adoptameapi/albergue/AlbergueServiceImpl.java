package xyz.rociofuentes.adoptameapi.albergue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbergueServiceImpl implements AlbergueService {
    private final AlbergueRepository albergueRepository;

    @Autowired
    public AlbergueServiceImpl(AlbergueRepository albergueRepository){
        this.albergueRepository = albergueRepository;
    }

    @Override
    public List<AlbergueDto> listarAlbergues(){
        return albergueRepository.findAll().stream()
                .map(a -> albergueADto(a))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AlbergueDto> traerAlberguePorId(Long id){
        return albergueRepository.findById(id)
                .map(a -> albergueADto(a));
    }

    @Override
    public Optional<AlbergueDto> traerAlberguePorCorreo(String correo){
        return albergueRepository.findByUsuario_Correo(correo)
                .map(a -> albergueADto(a));
    }

    private AlbergueDto albergueADto(Albergue a) {
        return AlbergueDto.builder()
                .id(a.getIdAlbergue())
                .nombre(a.getNombre())
                .direccion(a.getDireccion())
                .contacto(a.getContacto())
                .telefono(a.getTelefono())
                .correo(a.getUsuario().getCorreo())
                .build();
    }
}
