package academica.academicas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import academica.academicas.models.Evaluacion;
import academica.academicas.repository.EvaluacionRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EvaluacionService {

    private final EvaluacionRepository evaluacionRepository;

    public EvaluacionService(EvaluacionRepository evaluacionRepository) {
        this.evaluacionRepository = evaluacionRepository;
    }

    public Evaluacion guardarEvaluacion(Evaluacion evaluacion){
        return evaluacionRepository.save(evaluacion);
    }

    public List<Evaluacion> listarEvaluaciones(){
        return evaluacionRepository.findAll();
    }

    public List<Evaluacion> listarPorAsignaturaId(Long asignaturaId){
        return evaluacionRepository.findByAsignaturaId(asignaturaId);
    }

    public Optional<Evaluacion> obtenerEvaluacionPorId(Long id){
        return evaluacionRepository.findById(id);
    }

    public void eliminarEvaluacion(Long id){
        evaluacionRepository.deleteById(id);
    }
}
