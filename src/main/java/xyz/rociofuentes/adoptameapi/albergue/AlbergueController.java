package xyz.rociofuentes.adoptameapi.albergue;


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
@RequestMapping(path = "api/v1/albergues")
public class AlbergueController {

    private final AlbergueService albergueService;

    @Autowired
    public AlbergueController(AlbergueService albergueService) {
        this.albergueService = albergueService;
    }

    @GetMapping
    public List<Albergue> listarAlbergues() {return albergueService.listarAlbergues();}

    @GetMapping(path = "{id}")
    public Albergue traerAlberguePorId(@PathVariable("id") Long id){
        Optional<Albergue> resultado = albergueService.traerAlberguePorId(id);
        if (resultado.isPresent()){
            return resultado.get();
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Albergue no encontrado."
        );
    }

    @GetMapping(path = "correo/{correo}")
    public Albergue traerAlberguePorCorreo(@PathVariable("correo")String correo){
        Optional<Albergue> resultado = albergueService.traerAlberguePorCorreo(correo);
        if (resultado.isPresent()){
            return resultado.get();
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Alberge no encontrado con ese correo."
        );
    }

}
