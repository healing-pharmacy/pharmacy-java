package healingPharmacy.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer venda_id;

}
