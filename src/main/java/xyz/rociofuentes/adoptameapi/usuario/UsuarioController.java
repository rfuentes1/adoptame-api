package xyz.rociofuentes.adoptameapi.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController {
    public final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @GetMapping(path = "{correo}")
    public Usuario traerUsuarioPorId(@PathVariable("correo") String correo){
        Optional<Usuario> resultado = usuarioService.traerUsuarioPorId(correo);
        if (resultado.isPresent()){
            return resultado.get();
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Correo no encontrado."
        );
    }
}
