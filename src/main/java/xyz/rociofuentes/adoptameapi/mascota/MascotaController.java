package xyz.rociofuentes.adoptameapi.mascota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public List<Mascota> listarMascotas(){
        return mascotaService.listarMascotas();
    }

    @GetMapping(path = "{id}")
    public Mascota traerMascotaPorId(@PathVariable("id") Long id){
        Optional<Mascota> resultado = mascotaService.traerPorId(id);
        if(resultado.isPresent()){
            return resultado.get();
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Mascota no encontrada."
        );
    }

    @PostMapping
    public Mascota agregarMascota(@RequestBody Mascota mascota){
        return mascotaService.agregarMascota(mascota);
    }

}
