package healingPharmacy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Responsavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer responsavel_id;

    @Column(nullable = false, length = 150)
    private String nome_responsavel;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data_nascimento;

    @Column(nullable = false, length = 11)
    @NotNull(message = "{campo.cpf.obrigatorio.}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @Column(updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_cadastro;

    @Column
    private String telefone;

    @Column(nullable = true,length = 150)
    private String endereco;

    @Column(nullable = true,length = 150)
    private String email;

    @Column(nullable = true,length = 300)
    private String observacao;

    @PrePersist
    public void prePersist(){
        setData_cadastro(LocalDate.now());
    }
}
