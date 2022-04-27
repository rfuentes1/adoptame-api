package xyz.rociofuentes.adoptameapi.albergue;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import xyz.rociofuentes.adoptameapi.usuario.Usuario;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
public final class Albergue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlbergue;
    private String nombre;
    private String direccion;
    private String contacto;
    private String telefono;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "correo")
    @ToString.Exclude
    private Usuario usuario;

    public Albergue(){}
    public Albergue(Long idAlbergue, String nombre, String direccion, String contacto, String telefono, Usuario usuario){
        this.idAlbergue = idAlbergue;
        this.nombre = nombre;
        this.direccion = direccion;
        this.contacto = contacto;
        this.telefono = telefono;
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Albergue albergue = (Albergue) o;
        return idAlbergue != null && Objects.equals(idAlbergue, albergue.idAlbergue);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
