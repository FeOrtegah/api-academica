package academica.academicas.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import academica.academicas.models.Curso;
import academica.academicas.services.CursoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<Curso> crearCurso(@Valid @RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.guardarCurso(curso));
    }

    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos() {
        return ResponseEntity.ok(cursoService.listarCursos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerCursoPorId(@PathVariable Long id) {
        return cursoService.obtenerCursoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable Long id, @Valid @RequestBody Curso curso) {
        try {
            return ResponseEntity.ok(cursoService.actualizarCurso(id, curso));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        try {
            cursoService.eliminarCurso(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.badRequest().body(errors);
    }
}
