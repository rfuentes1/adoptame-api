package xyz.rociofuentes.adoptameapi.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    public final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
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
}
