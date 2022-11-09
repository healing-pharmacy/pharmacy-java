package healingPharmacy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

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
	private String nome;
	
	@Column(nullable = false, length = 11)
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

	@PrePersist
	public void prePersist(){
		setData_cadastro(LocalDate.now());
	}
}
