package xyz.rociofuentes.adoptameapi.mascota;

import xyz.rociofuentes.adoptameapi.albergue.AlbergueUtil;

public class MascotaUtil {

    public static MascotaDto mascotaADto(Mascota m){
        return MascotaDto.builder()
                .id(m.getIdMascota())
                .tipoMascota(m.getTipoMascota())
                .nombre(m.getNombre())
                .sexo(m.getSexo())
                .fechaNacimiento(m.getFechaNacimiento())
                .raza(m.getRaza())
                .descripcion(m.getDescripcion())
                .castrado(m.isCastrado())
                .fechaRegistro(m.getFechaRegistro())
                .disponible(m.isDisponible())
                .albergueDto(AlbergueUtil.albergueADto(m.getAlbergue()))
                .build();
    }

    public static Mascota dtoAMascota(MascotaDto dto){
        return new Mascota(
                dto.getId(),
                dto.getTipoMascota(),
                dto.getNombre(),
                dto.getSexo(),
                dto.getFechaNacimiento(),
                dto.getRaza(),
                dto.getDescripcion(),
                dto.isCastrado(),
                dto.getFechaRegistro(),
                dto.isDisponible(),
                AlbergueUtil.dtoAAlbergue(dto.getAlbergueDto())
        );
    }
}