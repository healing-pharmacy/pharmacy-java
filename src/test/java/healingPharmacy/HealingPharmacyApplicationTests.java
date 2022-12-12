package healingPharmacy;

import healingPharmacy.repository.RepositoryCliente;
import healingPharmacy.rest.ClienteController;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.BootstrapWith;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@SpringBootTest
class HealingPharmacyApplicationTests {



	@Test
	public void deveRetornarSucesso(){
	}

}
