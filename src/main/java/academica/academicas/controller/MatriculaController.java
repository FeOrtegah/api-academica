package academica.academicas.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import academica.academicas.models.Matricula;
import academica.academicas.services.MatriculaService;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @PostMapping
    public ResponseEntity<Matricula> crearMatricula(@RequestBody Matricula matricula) {
        return ResponseEntity.ok(matriculaService.guardarMatricula(matricula));
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> listarMatriculas() {
        return ResponseEntity.ok(matriculaService.listarMatriculas());
    }

    @GetMapping("/estudiante/{estudianteId}")
    public ResponseEntity<List<Matricula>> listarPorEstudiante(@PathVariable Long estudianteId) {
        return ResponseEntity.ok(matriculaService.listarPorEstudianteId(estudianteId));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMatricula(@PathVariable Long id) {
        matriculaService.eliminarMatricula(id);
        return ResponseEntity.noContent().build();
    }
}
