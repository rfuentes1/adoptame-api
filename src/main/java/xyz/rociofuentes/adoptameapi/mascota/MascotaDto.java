package xyz.rociofuentes.adoptameapi.mascota;

import lombok.Builder;
import lombok.Value;
import xyz.rociofuentes.adoptameapi.albergue.AlbergueDto;

import java.time.LocalDate;

@Builder
@Value
public class MascotaDto {
    Long id;
    String tipoMascota;
    String nombre;
    String sexo;
    LocalDate fechaNacimiento;
    String raza;
    String descripcion;
    boolean castrado;
    LocalDate fechaRegistro;
    boolean disponible;
    AlbergueDto albergueDto;
}