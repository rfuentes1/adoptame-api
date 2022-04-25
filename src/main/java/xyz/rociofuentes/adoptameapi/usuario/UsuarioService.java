package xyz.rociofuentes.adoptameapi.usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> listarUsuarios();
    Optional<Usuario> traerUsuarioPorId(String correo);
}
