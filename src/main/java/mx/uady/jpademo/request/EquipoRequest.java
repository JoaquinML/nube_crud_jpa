package mx.uady.jpademo.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class EquipoRequest{

    @NotNull
    @Min(value=0)
    @Max(value=100)
    private Integer id;

    @NotBlank
    @Size(min=3, max=255)
    private String modelo;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }
    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
