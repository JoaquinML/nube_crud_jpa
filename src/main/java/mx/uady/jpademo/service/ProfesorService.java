package mx.uady.jpademo.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uady.jpademo.exception.RecursoExistenteException;
import mx.uady.jpademo.exception.RecursoNoEncontradoException;
import mx.uady.jpademo.model.Profesor;
import mx.uady.jpademo.repository.ProfesorRepository;
import mx.uady.jpademo.request.ProfesorRequest;

@Service
public class ProfesorService{
    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Profesor> getProfesores(){
        List<Profesor> profesores = new LinkedList<>();
        profesorRepository.findAll().iterator().forEachRemaining(profesores :: add);
        return profesores;
    }

    public Profesor getProfesor(Integer id){
        boolean existeProfesor = profesorRepository.existsById(id);
        if(!existeProfesor){
            throw new RecursoNoEncontradoException("Profesor");
        }
        return profesorRepository.findById(id).get();
    }

    public Profesor guardarProfesor(ProfesorRequest request){
        boolean existeProfesor = profesorRepository.existsById(request.getId());
        if(existeProfesor){
            throw new RecursoExistenteException("Profesor");
        }

        Profesor profesor = new Profesor();
        profesor.setId(request.getId());
        profesor.setNombre(request.getNombre());
        profesor.setTutorias(request.getTutorias());

        return profesorRepository.save(profesor);
    }

    public void eliminarProfesor(Profesor profesor){
        profesorRepository.delete(profesor);
    }

    public Profesor editarProfesor(ProfesorRequest request){
        Profesor profesor = getProfesor(request.getId());

        profesor.setId(request.getId());
        profesor.setNombre(request.getNombre());
        profesor.setTutorias(request.getTutorias());

        return profesorRepository.save(profesor);
    }

}
