package xyz.rociofuentes.adoptameapi.usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<UsuarioDto> listarUsuarios();
    Optional<UsuarioDto> traerUsuarioPorId(String correo);
    UsuarioDto agregarUsuario(UsuarioDto usuarioDto);
}
