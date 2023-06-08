package healingPharmacy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer funcionario_id;

    @Column
    private String nome_funcionario;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data_nascimento;

    @Column(nullable = false, length = 11)
    @NotNull(message = "{campo.cpf.obrigatorio.}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @Column
    private String telefone;

    @Column(nullable = true,length = 150)
    private String endereco;
}
