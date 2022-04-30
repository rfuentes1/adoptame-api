package xyz.rociofuentes.adoptameapi.usuario;

import xyz.rociofuentes.adoptameapi.rol.RolUtil;

public class UsuarioUtil {

    public static UsuarioDto UsuarioADto(Usuario u){
        return UsuarioDto.builder()
                .correo(u.getCorreo())
                .passwordHash(u.getPasswordHash())
                .activo(u.isActivo())
                .fechaAlta(u.getFechaAlta())
                .rolDto(RolUtil.rolADto(u.getRol()))
                .build();
    }

    public static Usuario dtoAUsuario(UsuarioDto usuarioDto){
        return new Usuario(
        usuarioDto.getCorreo(),
        usuarioDto.getPasswordHash(),
        usuarioDto.getActivo(),
        usuarioDto.getFechaAlta(),
                RolUtil.dtoARol(usuarioDto.getRolDto())
        );
    }
}
