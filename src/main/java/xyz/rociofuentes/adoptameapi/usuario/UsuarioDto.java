package xyz.rociofuentes.adoptameapi.usuario;

import lombok.Builder;
import lombok.Value;
import xyz.rociofuentes.adoptameapi.rol.RolDto;

import java.time.LocalDate;

@Builder(toBuilder = true)
@Value
public class UsuarioDto {
    String correo;
    String passwordHash;
    Boolean activo;
    LocalDate fechaAlta;
    RolDto rolDto;
}