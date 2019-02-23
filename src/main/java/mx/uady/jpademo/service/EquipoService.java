package mx.uady.jpademo.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uady.jpademo.exception.RecursoExistenteException;
import mx.uady.jpademo.exception.RecursoNoEncontradoException;
import mx.uady.jpademo.model.Equipo;
import mx.uady.jpademo.repository.EquipoRepository;
import mx.uady.jpademo.request.EquipoRequest;

@Service
public class EquipoService{

    @Autowired
    private EquipoRepository equipoRepository;

    public Equipo guardarEquipo(EquipoRequest request){

        boolean existeEquipo = equipoRepository.existsById(request.getId());

        if(existeEquipo){
            throw new RecursoExistenteException("alumno");
        }

        Equipo equipo = new Equipo();
        equipo.setId(request.getId());
        equipo.setModelo(request.getModelo());
        return equipoRepository.save(equipo);
    }

    public List<Equipo> equipos(){
        List<Equipo> equipos = new LinkedList<>();
        equipoRepository.findAll().iterator().forEachRemaining(equipos :: add);
        return equipos;
    }

    public Equipo getEquipo(Integer id){
        boolean existeEquipo = equipoRepository.existsById(id);
        if (!existeEquipo) {
            throw new RecursoNoEncontradoException("Equipo");
        }

        return equipoRepository.findById(id).get();
    }

    public void eliminarEquipo(Equipo equipo){
        equipoRepository.delete(equipo);
    }

    public Equipo editarEquipo(EquipoRequest request){
        Equipo  equipo = getEquipo(request.getId());

        equipo.setId(request.getId());
        equipo.setModelo(request.getModelo());

        return equipoRepository.save(equipo);

    }

}
