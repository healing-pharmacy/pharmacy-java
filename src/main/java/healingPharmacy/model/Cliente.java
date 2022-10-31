package healingPharmacy.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Cli_id;
	
	@Column(nullable = false, length = 150)
	private String nome;
	
	@Column(nullable = false, length = 11)
	private String CPF;
	
	@Column
	private LocalDate dataCadastro;

	@Column
	private Date dataNascimento;

	@Column(nullable = false, length = 150)
	private String endereco;

	@Column(nullable = false, length = 150)
	private String email;
}
