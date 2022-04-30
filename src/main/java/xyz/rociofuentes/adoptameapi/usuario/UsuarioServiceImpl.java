package xyz.rociofuentes.adoptameapi.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.rociofuentes.adoptameapi.rol.Rol;
import xyz.rociofuentes.adoptameapi.rol.RolRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    public final UsuarioRepository usuarioRepository;
    public final RolRepository rolRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, RolRepository rolRepository){
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    public List<UsuarioDto> listarUsuarios(){
        return usuarioRepository.findAll().stream()
                .map(u -> UsuarioUtil.UsuarioADto(u))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UsuarioDto> traerUsuarioPorId(String correo) {
        return usuarioRepository.findById(correo)
                .map(u -> UsuarioUtil.UsuarioADto(u));
    }

    @Override
    public UsuarioDto agregarUsuario(UsuarioDto usuarioDto) {
        //Convert from Dto to entity
        Usuario usuario = UsuarioUtil.dtoAUsuario(usuarioDto);

        Long idRol = usuario.getRol().getIdRol();
        Rol rolBd = rolRepository.findById(idRol)
                .orElseThrow(() -> new EntityNotFoundException("El id del rol no encontrado."));
        usuario.setRol(rolBd);
        return UsuarioUtil.UsuarioADto(usuarioRepository.save(usuario));
    }
}
