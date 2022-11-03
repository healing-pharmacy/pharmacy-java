package healingPharmacy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usu_id;

    @Column(nullable = false,length = 150)
    private String nome;

    @Column(nullable = false)
    private Date data_nascimento;

    @Column(nullable = false,length = 150)
    private String cpf;

}
