package academica.academicas.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import academica.academicas.models.Asignatura;
import academica.academicas.repository.AsignaturaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;

    public AsignaturaService(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    public Asignatura guardarAsignatura(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    public Asignatura actualizarAsignatura(Long id, Asignatura datos) {
        Asignatura existente = asignaturaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));
        if (datos.getNombre() != null) existente.setNombre(datos.getNombre());
        if (datos.getCursoId() != null) existente.setCursoId(datos.getCursoId());
        if (datos.getProfesorId() != null) existente.setProfesorId(datos.getProfesorId());
        return asignaturaRepository.save(existente);
    }

    public List<Asignatura> listarAsignaturas() {
        return asignaturaRepository.findAll();
    }

    public List<Asignatura> listarPorCursoId(Long cursoId) {
        return asignaturaRepository.findByCursoId(cursoId);
    }

    public Optional<Asignatura> obtenerAsignaturaPorId(Long id) {
        return asignaturaRepository.findById(id);
    }

    public void eliminarAsignatura(Long id) {
        asignaturaRepository.deleteById(id);
    }
}
