package xyz.rociofuentes.adoptameapi.adoptame;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String correo;
    private String passwordHash;
    private boolean activo;
    private LocalDate fechaAlta;

    public Usuario(){}
    public Usuario(String correo, String passwordHash, boolean activo, LocalDate fechaAlta, Rol rol) {
        this.correo = correo;
        this.passwordHash = passwordHash;
        this.activo = activo;
        this.fechaAlta = fechaAlta;
        this.rol = rol;
    }

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Usuario usuario = (Usuario) o;
        return correo != null && Objects.equals(correo, usuario.correo);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
