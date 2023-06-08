package healingPharmacy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer diagnostico_id;

    @Column
    private String nome_diagnostico;

    @Column
    private Boolean paleativo;

    @Column(length = 250)
    private String obs;

}
