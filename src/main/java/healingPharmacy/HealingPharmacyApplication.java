package healingPharmacy;

import healingPharmacy.model.Cliente;
import healingPharmacy.repository.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
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

}
