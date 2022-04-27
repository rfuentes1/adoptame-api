package xyz.rociofuentes.adoptameapi.mascota;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import xyz.rociofuentes.adoptameapi.albergue.Albergue;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
public final class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMascota;
    private String tipoMascota;
    private String nombre;
    private String sexo;
    private LocalDate fechaNacimiento;
    private String raza;
    private String descripcion;
    private boolean castrado;
    private LocalDate fechaRegistro;
    private boolean disponible;

    @ManyToOne
    @JoinColumn(name = "id_albergue", nullable = false)
    private Albergue albergue;

    public Mascota(){}
    public Mascota(Long idMascota, String tipoMascota, String nombre, String sexo, LocalDate fechaNacimiento, String raza, String descripcion, boolean castrado, LocalDate fechaRegistro, boolean disponible, Albergue albergue) {
        this.idMascota = idMascota;
        this.tipoMascota = tipoMascota;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.raza = raza;
        this.descripcion = descripcion;
        this.castrado = castrado;
        this.fechaRegistro = fechaRegistro;
        this.disponible = disponible;
        this.albergue = albergue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Mascota mascota = (Mascota) o;
        return idMascota != null && Objects.equals(idMascota, mascota.idMascota);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
