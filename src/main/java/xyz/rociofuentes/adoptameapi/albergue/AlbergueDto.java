package xyz.rociofuentes.adoptameapi.albergue;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value //genera getters y setters y aparte los marca como privados automáticamente
public class AlbergueDto {
    Long id;
    String nombre;
    String direccion;
    String contacto;
    String telefono;
    String correo;
}
