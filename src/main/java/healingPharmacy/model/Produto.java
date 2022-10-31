package healingPharmacy.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prod_id;

    @Column(nullable = false,length = 150)
    private String descricao;
}
