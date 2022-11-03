package healingPharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import healingPharmacy.model.Cliente;

public class RepositoryCliente {
	public boolean validar(Cliente cliente) {
		return true;
	}
	
	
	public void persistir() {
		
	}
}
