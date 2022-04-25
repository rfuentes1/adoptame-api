package xyz.rociofuentes.adoptameapi.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    public final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> traerUsuarioPorId(String correo) {
        return usuarioRepository.findById(correo);
    }


}
