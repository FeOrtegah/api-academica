package academica.academicas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "notas")
@AllArgsConstructor
@NoArgsConstructor
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El valor de la nota es obligatorio")
    @DecimalMin(value = "1.0", message = "La nota mínima es 1.0")
    @DecimalMax(value = "7.0", message = "La nota máxima es 7.0")
    private Double valor;

    @NotNull(message = "El estudianteId es obligatorio")
    private Long estudianteId;

    @NotNull(message = "El evaluacionId es obligatorio")
    private Long evaluacionId;

    @Size(max = 500, message = "El comentario no puede superar 500 caracteres")
    private String comentario;
}
