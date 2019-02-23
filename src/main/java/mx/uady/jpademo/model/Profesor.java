package mx.uady.jpademo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    private Integer id;

    @Column
    private String nombre;

    @OneToMany(mappedBy = "profesor")
    @JsonBackReference(value="profesor-tutoria")
    private List<Tutoria> tutorias;

    public Profesor() {
    }

    public Profesor(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
    * Returns value of id
    * @return
    */
    public Integer getId() {
    	return id;
    }

    /**
    * Sets new value of id
    * @param
    */
    public void setId(Integer id) {
    	this.id = id;
    }

    /**
    * Returns value of nombre
    * @return
    */
    public String getNombre() {
    	return nombre;
    }

    /**
    * Sets new value of nombre
    * @param
    */
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }

    /**
    * Returns value of tutorias
    * @return
    */
    public List<Tutoria> getTutorias() {
    	return tutorias;
    }

    /**
    * Sets new value of tutorias
    * @param
    */
    public void setTutorias(List<Tutoria> tutorias) {
    	this.tutorias = tutorias;
    }


	/**
	* Create string representation of Profesor for printing
	* @return
	*/
	@Override
	public String toString() {
		return "Profesor [id=" + getId() + ", nombre=" + getNombre() + ", tutorias=" + getTutorias() + "]";
	}
}
