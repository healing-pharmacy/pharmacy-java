package healingPharmacy.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

@Entity
@Data
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
	
	@Column
	private LocalDate data_cadastro;

	@Column
	private Date data_nascimento;

	@Column(nullable = false, length = 150)
	private String endereco;

	@Column(nullable = false, length = 150)
	private String email;

	@PrePersist
	public void prePersist(){
		setData_cadastro(LocalDate.now());
	}
}
