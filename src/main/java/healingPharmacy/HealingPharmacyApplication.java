package healingPharmacy;

import healingPharmacy.model.Paciente;
import healingPharmacy.repository.IPaciente;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HealingPharmacyApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(HealingPharmacyApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(IPaciente dao){
		return args -> {
			dao.deleteAll();

			Paciente p = new Paciente();
			p.setNome_paciente("Samuel");
			p.setCpf("06343161171");
			p.setEmail("samuelcostta2306@gmail.com");
			p.setEndereco("Rua filsotro carneiro qd06 lt16");
			p.setTelefone("62 98582-4804");
			//p.setData_nascimento();

			Paciente f = new Paciente();
			f.setNome_paciente("Maria");
			f.setCpf("06343161171");
			f.setEmail("mariasilva@gmail.com");
			f.setEndereco("Rua das couves qd06 lt16");
			f.setTelefone("62 91231-9843");
			//p.setData_nascimento();

			dao.save(p);
			dao.save(f);
		};
	}
}
