package xyz.rociofuentes.adoptameapi.mascota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/mascotas")
public class MascotaController {

    private final MascotaService mascotaService;

    @Autowired
    public MascotaController(MascotaService mascotaService){
        this.mascotaService = mascotaService;
    }

    @GetMapping
    public List<MascotaDto> listarMascotas(){
        return mascotaService.listarMascotas();
    }

    @GetMapping(path = "{id}")
    public MascotaDto traerMascotaPorId(@PathVariable("id") Long id){
        Optional<MascotaDto> resultado = mascotaService.traerPorId(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Mascota no encontrada."
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MascotaDto publicarMascota(@RequestBody MascotaDto mascotaDto){
        try {
            return mascotaService.agregarOEditarMascota(mascotaDto);
        }catch(EntityNotFoundException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage()
            );
        }
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarMascota(@PathVariable("id") Long id){
        try {
            mascotaService.marcarNoDisponible(id);
        }catch(EntityNotFoundException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "El id de mascota no existe"
            );
        }
    }

    @PutMapping(path = "{id}")
    public MascotaDto actualizarMascota(@PathVariable("id") Long id,  @RequestBody MascotaDto mascotaDto){
        // I added the id from the path variable to the Mascota Object
        mascotaDto = mascotaDto.toBuilder().id(id).build();
        try {
            return mascotaService.agregarOEditarMascota(mascotaDto);
        }catch(EntityNotFoundException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, e.getMessage()
            );
        }
    }
}

