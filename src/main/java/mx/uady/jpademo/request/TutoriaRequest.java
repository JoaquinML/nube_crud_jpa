package mx.uady.jpademo.request;

import mx.uady.jpademo.model.Profesor;
import mx.uady.jpademo.model.Alumno;
import javax.validation.constraints.NotNull;
import mx.uady.jpademo.model.Tutoria.TutoriaId;


public class TutoriaRequest{

  @NotNull
  private TutoriaId id;

  private Alumno alumno;

  private Profesor profesor;

  private Integer horas;


	/**
	* Returns value of id
	* @return
	*/
	public TutoriaId getId() {
		return id;
	}

	/**
	* Sets new value of id
	* @param
	*/
	public void setId(TutoriaId id) {
		this.id = id;
	}

	/**
	* Returns value of alumno
	* @return
	*/
	public Alumno getAlumno() {
		return alumno;
	}

	/**
	* Sets new value of alumno
	* @param
	*/
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	/**
	* Returns value of profesor
	* @return
	*/
	public Profesor getProfesor() {
		return profesor;
	}

	/**
	* Sets new value of profesor
	* @param
	*/
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	/**
	* Returns value of horas
	* @return
	*/
	public Integer getHoras() {
		return horas;
	}

	/**
	* Sets new value of horas
	* @param
	*/
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
}
