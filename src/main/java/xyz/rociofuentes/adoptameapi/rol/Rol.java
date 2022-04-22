package xyz.rociofuentes.adoptameapi.rol;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;


@Getter @Setter
@ToString
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
    private String nombre;

    public Rol(){}
    public Rol(Long idRol, String nombre){
        this.idRol = idRol;
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Rol rol = (Rol) o;
        return idRol != null && Objects.equals(idRol, rol.idRol);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
