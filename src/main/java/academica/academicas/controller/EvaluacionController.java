package academica.academicas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academica.academicas.models.Evaluacion;
import academica.academicas.services.EvaluacionService;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

    private final EvaluacionService evaluacionService;

    public EvaluacionController(EvaluacionService evaluacionService) {
        this.evaluacionService = evaluacionService;
    }

    @PostMapping
    public ResponseEntity<Evaluacion> crearEvaluacion(@RequestBody Evaluacion evaluacion) {
        return ResponseEntity.ok(evaluacionService.guardarEvaluacion(evaluacion));
    }

    @GetMapping
    public ResponseEntity<List<Evaluacion>> listarEvaluaciones() {
        return ResponseEntity.ok(evaluacionService.listarEvaluaciones());
    }

    @GetMapping("/asignatura/{asignaturaId}")
    public ResponseEntity<List<Evaluacion>> listarEvaluacionesPorAsignatura(@PathVariable Long asignaturaId) {
        return ResponseEntity.ok(evaluacionService.listarPorAsignaturaId(asignaturaId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evaluacion> obtenerEvaluacionPorId(@PathVariable Long id) {
        return evaluacionService.obtenerEvaluacionPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEvaluacion(@PathVariable Long id) {
        evaluacionService.eliminarEvaluacion(id);
        return ResponseEntity.noContent().build();
    }
}
