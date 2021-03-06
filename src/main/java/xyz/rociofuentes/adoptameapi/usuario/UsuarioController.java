package xyz.rociofuentes.adoptameapi.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
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
    public List<UsuarioDto> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @GetMapping(path = "{correo}")
    public UsuarioDto traerUsuarioPorId(@PathVariable("correo") String correo){
        Optional<UsuarioDto> resultado = usuarioService.traerUsuarioPorId(correo);
        if (resultado.isPresent()){
            return resultado.get();
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Correo no encontrado."
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto publicarUsuario(@RequestBody UsuarioDto usuarioDto){
        try{
            return usuarioService.agregarUsuario(usuarioDto);
        }catch (EntityNotFoundException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage()
            );
        }
    }
}
