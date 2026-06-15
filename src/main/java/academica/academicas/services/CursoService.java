package academica.academicas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import academica.academicas.models.Curso;
import academica.academicas.repository.CursoRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso guardarCurso(Curso curso){
        return cursoRepository.save(curso);
    }

    public List<Curso> listarCursos(){
        return cursoRepository.findAll();
    }

    public Optional<Curso> obtenerCursoPorId(Long id){
        return cursoRepository.findById(id);
    }

    public void eliminarCurso(Long id){
        cursoRepository.deleteById(id);
    }

    public Curso actualizarCurso(Long id, Curso cursoActualizado){
        Optional<Curso> cursoExistenteOpt = cursoRepository.findById(id);
        if (cursoExistenteOpt.isPresent()) {
            Curso cursoExistente = cursoExistenteOpt.get();
            cursoExistente.setNombre(cursoActualizado.getNombre());
            cursoExistente.setAnio(cursoActualizado.getAnio());
            return cursoRepository.save(cursoExistente);
        } else {
            throw new IllegalArgumentException("Curso con ID " + id + " no encontrado");
        }
    }
}
