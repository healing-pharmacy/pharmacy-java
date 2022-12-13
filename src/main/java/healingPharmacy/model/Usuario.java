package healingPharmacy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usu_id;

    @Column(name = "username",nullable = false,length = 150)
    private String usernome;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(nullable = false)
    private Date data_nascimento;

    @Column(nullable = false,length = 150)
    private String cpf;

}
