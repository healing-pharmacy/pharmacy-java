package healingPharmacy.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prod_id;

    @Column
    private String nome;

    @Column
    private String marca;

    @Column
    private String categoria;

    @Column
    private Integer quantidade;

    @Column(nullable = false,length = 150)
    private String descricao;
}
