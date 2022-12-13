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
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer forn_id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 14)
    private String cnpj;


}
