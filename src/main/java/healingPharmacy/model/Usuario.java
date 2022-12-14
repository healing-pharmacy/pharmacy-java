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

    @Column(name = "username",nullable = true,length = 150)
    private String username;

    @Column(name = "email",nullable = true, length = 150)
    private String email;

    @Column(name = "password", nullable = true)
    private String password;

    @Column(nullable = true)
    private Date data_nascimento;

    @Column(nullable = true,length = 150)
    private String cpf;

}
