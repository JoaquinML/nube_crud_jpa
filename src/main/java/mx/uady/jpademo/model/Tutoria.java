package mx.uady.jpademo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tutorias")
public class Tutoria {

    @EmbeddedId
    private TutoriaId id;

    @ManyToOne
    @MapsId("id_alumno")
    @JoinColumn(name = "id_alumno")
    @JsonBackReference(value="alumno-tutoria")
    private Alumno alumno;

    @ManyToOne
    @MapsId("id_profesor")
    @JoinColumn(name = "id_profesor")
    @JsonBackReference(value="profesor-tutoria")
    private Profesor profesor;

    @Column(name = "horas")
    private Integer horas;

    @Embeddable
    public static class TutoriaId implements Serializable {

        private static final long serialVersionUID = 1L;

        @Column(name = "id_alumno")
        Integer alumnoId;

        @Column(name = "id_profesor")
        Integer profesorId;

        public TutoriaId() { }

        /**
         * @return the alumnoId
         */
        public Integer getAlumnoId() {
            return alumnoId;
        }/**
         * @param alumnoId the alumnoId to set
         */
        public void setAlumnoId(Integer alumnoId) {
            this.alumnoId = alumnoId;
        }/**
         * @return the profesorId
         */
        public Integer getProfesorId() {
            return profesorId;
        }/**
         * @param profesorId the profesorId to set
         */
        public void setProfesorId(Integer profesorId) {
            this.profesorId = profesorId;
        }
    }

    public Tutoria() {
    }

    public Tutoria(TutoriaId id, Alumno alumno, Profesor profesor, Integer horas) {
        this.id = id;
        this.alumno = alumno;
        this.profesor = profesor;
        this.horas = horas;
    }

    public TutoriaId getId() {
        return this.id;
    }

    public void setId(TutoriaId id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return this.alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Profesor getProfesor() {
        return this.profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Integer getHoras() {
        return this.horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Tutoria id(TutoriaId id) {
        this.id = id;
        return this;
    }

    public Tutoria alumno(Alumno alumno) {
        this.alumno = alumno;
        return this;
    }

    public Tutoria profesor(Profesor profesor) {
        this.profesor = profesor;
        return this;
    }

    public Tutoria horas(Integer horas) {
        this.horas = horas;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", alumno='" + getAlumno() + "'" +
            ", profesor='" + getProfesor() + "'" +
            ", horas='" + getHoras() + "'" +
            "}";
    }



}
