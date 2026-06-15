package academica.academicas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academica.academicas.models.Nota;
import academica.academicas.services.NotaService;

@RestController
@RequestMapping("/api/notas")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @PostMapping
    public ResponseEntity<Nota> crearNota(@RequestBody Nota nota) {
        return ResponseEntity.ok(notaService.guardarNota(nota));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> actualizarNota(@PathVariable Long id, @RequestBody Nota nota) {
        nota.setId(id);
        return ResponseEntity.ok(notaService.guardarNota(nota));
    }

    @GetMapping
    public ResponseEntity<List<Nota>> listarNotas() {
        return ResponseEntity.ok(notaService.listarNotas());
    }

    @GetMapping("/evaluacion/{evaluacionId}")
    public ResponseEntity<List<Nota>> listarNotasPorEvaluacion(@PathVariable Long evaluacionId) {
        return ResponseEntity.ok(notaService.listarPorEvaluacionId(evaluacionId));
    }

    @GetMapping("/estudiante/{estudianteId}")
    public ResponseEntity<List<Nota>> listarNotasPorEstudiante(@PathVariable Long estudianteId) {
        return ResponseEntity.ok(notaService.listarPorEstudianteId(estudianteId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> obtenerNotaPorId(@PathVariable Long id) {
        return notaService.obtenerNotaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNota(@PathVariable Long id) {
        notaService.eliminarNota(id);
        return ResponseEntity.noContent().build();
    }
}
