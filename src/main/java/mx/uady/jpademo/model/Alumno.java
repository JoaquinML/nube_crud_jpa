package mx.uady.jpademo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable{

    @Id
    private Integer id;

    @Column
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipoId;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuarioId;

    @OneToMany(mappedBy = "alumno")
    @JsonManagedReference(value="alumno-tutoria")
    private Set<Tutoria> tutorias;

    public Alumno() {
    }

    public Alumno(Integer id, String nombre, Equipo equipoId, Usuario usuarioId, Set<Tutoria> tutorias) {
        this.id = id;
        this.nombre = nombre;
        this.equipoId = equipoId;
        this.usuarioId = usuarioId;
        this.tutorias = tutorias;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Equipo getEquipoId() {
        return this.equipoId;
    }

    public void setEquipoId(Equipo equipoId) {
        this.equipoId = equipoId;
    }

    public Usuario getUsuarioId() {
        return this.usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Set<Tutoria> getTutorias() {
        return this.tutorias;
    }

    public void setTutorias(Set<Tutoria> tutorias) {
        this.tutorias = tutorias;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", equipoId='" + getEquipoId() + "'" +
            ", usuarioId='" + getUsuarioId() + "'" +
            ", tutorias='" + getTutorias() + "'" +
            "}";
    }

}
