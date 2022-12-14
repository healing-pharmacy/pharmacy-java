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
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer forn_id;

    @Column(nullable = false, length = 14)
    private String cnpj;

    @Column(nullable = false, length = 150)
    @NotEmpty( message = "{campo.nome.obrigatorio}")
    private String razao_social;

    @Column(nullable = false, length = 150)
    @NotEmpty( message = "{campo.nome.obrigatorio}")
    private String nome_fantasia;

    @Column(updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_cadastro;

    @Column
    private String telefone;

    @Column(nullable = true,length = 150)
    private String endereco;

    @Column(nullable = true,length = 150)
    private String email;

    @Column(nullable = true,length = 150)
    private String responsavel;

    @Column(nullable = true,length = 300)
    private String observacao;

    @PrePersist
    public void prePersist(){
        setData_cadastro(LocalDate.now());
    }
}
