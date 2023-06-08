package healingPharmacy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicamento_id;

    @Column
    private String nome_medicamento;

    @Column
    private Integer quantidade;

    @Column(updatable = true)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_validade;

    @Column
    private Integer mg;

    @Column(nullable = false,length = 150)
    private String tarja;
}
