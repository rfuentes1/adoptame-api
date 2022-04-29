package xyz.rociofuentes.adoptameapi.albergue;

import xyz.rociofuentes.adoptameapi.usuario.Usuario;

public class AlbergueUtil {
    public static AlbergueDto albergueADto(Albergue a) {
        return AlbergueDto.builder()
                .id(a.getIdAlbergue())
                .nombre(a.getNombre())
                .direccion(a.getDireccion())
                .contacto(a.getContacto())
                .telefono(a.getTelefono())
                .estaActivo(a.getEstaActivo())
                .correo(a.getUsuario().getCorreo())
                .build();
    }

    public static Albergue dtoAAlbergue(AlbergueDto dto){
        Usuario usuario = new Usuario();
        usuario.setCorreo(dto.getCorreo());
        return new Albergue(
                dto.getId(),
                dto.getNombre(),
                dto.getDireccion(),
                dto.getContacto(),
                dto.getTelefono(),
                dto.getEstaActivo(),
                usuario
                );
    }


}
