package academica.academicas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import academica.academicas.models.Nota;
import academica.academicas.repository.NotaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class NotaService {

    private final NotaRepository notaRepository;

    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    public Nota guardarNota(Nota nota){
        if (nota.getValor() == null) {
            throw new IllegalArgumentException("La nota no puede ser nula");
        }
        if (nota.getValor() < 1.0 || nota.getValor() > 7.0) {
            throw new IllegalArgumentException("La nota debe estar entre 1.0 y 7.0");
        }
        return notaRepository.save(nota);
    }

    public List<Nota> listarNotas(){
        return notaRepository.findAll();
    }

    public List<Nota> listarPorEvaluacionId(Long evaluacionId){
        return notaRepository.findByEvaluacionId(evaluacionId);
    }

    public List<Nota> listarPorEstudianteId(Long estudianteId){
        return notaRepository.findByEstudianteId(estudianteId);
    }

    public Optional<Nota> obtenerNotaPorId(Long id){
        return notaRepository.findById(id);
    }

    public void eliminarNota(Long id){
        notaRepository.deleteById(id);
    }

}
