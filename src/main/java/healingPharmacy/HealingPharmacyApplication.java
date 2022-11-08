package healingPharmacy;

import healingPharmacy.model.Cliente;
import healingPharmacy.repository.RepositoryCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HealingPharmacyApplication {
	
	@Bean
	public CommandLineRunner run( @Autowired RepositoryCliente repository){
		return args -> {
			Cliente cliente = Cliente.builder().cpf("12345678911").nome("Fulano").build();
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(HealingPharmacyApplication.class, args);
	}

}
