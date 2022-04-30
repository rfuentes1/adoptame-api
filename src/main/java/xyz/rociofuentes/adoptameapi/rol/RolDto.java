package xyz.rociofuentes.adoptameapi.rol;

import lombok.Builder;
import lombok.Value;

@Builder(toBuilder = true)
@Value
public class RolDto {
    Long id;
    String nombre;
}
