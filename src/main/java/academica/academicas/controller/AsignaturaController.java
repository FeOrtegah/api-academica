package academica.academicas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import academica.academicas.models.Asignatura;
import academica.academicas.services.AsignaturaService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    private final AsignaturaService asignaturaService;

    public AsignaturaController(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }

    @PostMapping
    public ResponseEntity<Asignatura> crearAsignatura(@RequestBody Asignatura asignatura) {
        return ResponseEntity.ok(asignaturaService.guardarAsignatura(asignatura));
    }

    @GetMapping
    public ResponseEntity<List<Asignatura>> listarAsignaturas() {
        return ResponseEntity.ok(asignaturaService.listarAsignaturas());
    }
    
    @GetMapping("/curso/{cursoId}")
    public ResponseEntity<List<Asignatura>> listarAsignaturasPorCurso(@PathVariable Long cursoId) {
        return ResponseEntity.ok(asignaturaService.listarPorCursoId(cursoId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> obtenerAsignaturaPorId(@PathVariable Long id) {
        return asignaturaService.obtenerAsignaturaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> actualizarAsignatura(@PathVariable Long id, @RequestBody Asignatura asignatura) {
        return ResponseEntity.ok(asignaturaService.actualizarAsignatura(id, asignatura));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAsignatura(@PathVariable Long id) {
        asignaturaService.eliminarAsignatura(id);
        return ResponseEntity.noContent().build();
    }
}
