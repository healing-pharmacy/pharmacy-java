package healingPharmacy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Cli_id;
	
	@Column(nullable = false, length = 150)
	@NotEmpty( message = "{campo.nome.obrigatorio}")
	private String nome;
	
	@Column(nullable = false, length = 11)
	@NotNull(message = "{campo.cpf.obrigatorio.}")
	@CPF(message = "{campo.cpf.invalido}")
	private String cpf;
	
	@Column(updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data_cadastro;

	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data_nascimento;

	@Column(nullable = true,length = 150)
	private String endereco;

	@Column(nullable = true,length = 150)
	private String email;

<<<<<<< Updated upstream
	@PrePersist
	public void prePersist(){
		setData_cadastro(LocalDate.now());
	}
=======
	@Column(name="userName", nullable=false, unique=true)
	private String nomeUsuario;


	@Column(name="password", nullable=false, unique=false)
	private String senha;
>>>>>>> Stashed changes
}
