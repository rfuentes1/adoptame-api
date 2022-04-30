package xyz.rociofuentes.adoptameapi.rol;

public class RolUtil {
    public static RolDto rolADto(Rol r){
        return RolDto.builder()
                .id(r.getIdRol())
                .nombre(r.getNombre())
                .build();
    }

    public static Rol dtoARol(RolDto r) {
        return new Rol(
                r.getId(),
                r.getNombre()
        );
    }
}
