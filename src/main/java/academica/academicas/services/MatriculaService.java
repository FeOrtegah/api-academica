package academica.academicas.services;

import java.util.List;
import org.springframework.stereotype.Service;
import academica.academicas.models.Matricula;
import academica.academicas.repository.MatriculaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    public Matricula guardarMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    public List<Matricula> listarMatriculas() {
        return matriculaRepository.findAll();
    }

    public List<Matricula> listarPorEstudianteId(Long estudianteId) {
        return matriculaRepository.findByEstudianteId(estudianteId);
    }
    public void eliminarMatricula(Long id) {
    matriculaRepository.deleteById(id);
    }
}
