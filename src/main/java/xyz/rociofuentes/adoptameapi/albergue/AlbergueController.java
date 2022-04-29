package xyz.rociofuentes.adoptameapi.albergue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
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
    public List<AlbergueDto> listarAlbergues() {return albergueService.listarAlbergues();}

    @GetMapping(path = "{id}")
    public AlbergueDto traerAlberguePorId(@PathVariable("id") Long id){
        Optional<AlbergueDto> resultado = albergueService.traerAlberguePorId(id);
        if (resultado.isPresent()){
            return resultado.get();
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Albergue no encontrado."
        );
    }

    @GetMapping(path = "correo/{correo}")
    public AlbergueDto traerAlberguePorCorreo(@PathVariable("correo")String correo){
        Optional<AlbergueDto> resultado = albergueService.traerAlberguePorCorreo(correo);
        if (resultado.isPresent()){
            return resultado.get();
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Alberge no encontrado con ese correo."
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlbergueDto agregarAlbergue(@RequestBody AlbergueDto albergueDto){
        try {
            return albergueService.agregarOEditarAlbergue(albergueDto);
        }catch (EntityNotFoundException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage()
            );
        }
    }

    @PutMapping(path = "{id}")
    public AlbergueDto acualizarAlbergue(@PathVariable("id") Long id, @RequestBody AlbergueDto albergueDto){
        // Add the Id passed through the endpoint to the Albergue object
        albergueDto = albergueDto.toBuilder().id(id).build();
        try {
            return albergueService.agregarOEditarAlbergue(albergueDto);
        }catch (EntityNotFoundException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage()
            );
        }
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarAlbergue(@PathVariable("id") Long id){
        try{
            albergueService.marcarAlbergueNoDisponible(id);
        }catch (EntityNotFoundException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "El id del albergue no existe"
            );
        }
    }
}