package xyz.rociofuentes.adoptameapi.albergue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.rociofuentes.adoptameapi.usuario.Usuario;
import xyz.rociofuentes.adoptameapi.usuario.UsuarioRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbergueServiceImpl implements AlbergueService {
    private final AlbergueRepository albergueRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public AlbergueServiceImpl(AlbergueRepository albergueRepository, UsuarioRepository usuarioRepository){
        this.albergueRepository = albergueRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<AlbergueDto> listarAlbergues(){
        return albergueRepository.findAll().stream()
                .map(a -> AlbergueUtil.albergueADto(a))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AlbergueDto> traerAlberguePorId(Long id){
        return albergueRepository.findById(id)
                .map(a -> AlbergueUtil.albergueADto(a));
    }

    @Override
    public Optional<AlbergueDto> traerAlberguePorCorreo(String correo){
        return albergueRepository.findByUsuario_Correo(correo)
                .map(a -> AlbergueUtil.albergueADto(a));
    }

    @Override
    public AlbergueDto agregarOEditarAlbergue(AlbergueDto albergueDto) {
        // if the id is present then validate that the entry exists
        if(albergueDto.getId() != null){
            if(!albergueRepository.existsById(albergueDto.getId()))
                    throw new EntityNotFoundException("El id del albergue no fue encontrado");
        }
        // Convert from albergueDto to entity
        Albergue albergue = AlbergueUtil.dtoAAlbergue(albergueDto);
        //get correoUsuario
        String correoUsuario = albergue.getUsuario().getCorreo();
        //retrieve from the database the usuario entity with the previos email
        // if it's not found throw an exception
        Usuario usuarioDb = usuarioRepository.findById(correoUsuario)
                .orElseThrow(() -> new EntityNotFoundException("Correo de usuario no encontrado"));
        //if the user was found, the empty usuario will be replaced with the one from the reposiroty
        albergue.setUsuario(usuarioDb);
        // return the albergue and the full user entity
        return AlbergueUtil.albergueADto(albergueRepository.save(albergue));
    }

    @Override
    public void marcarAlbergueNoDisponible(Long id) {
        Albergue albergue = albergueRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Id de albergue no encontrado"));
        albergue.setEstaActivo(false);
        albergueRepository.save(albergue);
    }
}