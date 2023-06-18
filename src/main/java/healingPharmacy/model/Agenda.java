package healingPharmacy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer agenda_id;

    @Column
    @Temporal(TemporalType.DATE)
    private Calendar hora;

    @Column
    private Integer dia;

    @Column
    private Integer mes;

    @Column
    private Integer ano;

    @Column
    private String responsavel;

    @Column
    private Boolean concluido;

    @Column
    private String tarefa;

}
