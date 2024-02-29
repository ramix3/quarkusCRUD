import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="Libros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Libros {
    @Id @GeneratedValue
    private Long id;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "autor")
    private String autor;
    @Column(name = "fechaPublicacion")
    private Date fechaPublicacion;
    @Column(name = "calificacion")
    private String calificacion;


}
