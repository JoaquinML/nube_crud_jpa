package mx.uady.jpademo.request;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import mx.uady.jpademo.model.Tutoria;

public class ProfesorRequest{

    @Min(value=0)
    @Max(value=100)
    private Integer id;

    @NotBlank
    @Size(min=3, max=255)
    private String nombre;

    private List<Tutoria> tutorias;

    public ProfesorRequest(){}

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the tutorias
     */
    public List<Tutoria> getTutorias() {
        return tutorias;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param tutorias the tutorias to set
     */
    public void setTutorias(List<Tutoria> tutorias) {
        this.tutorias = tutorias;
    }

}
