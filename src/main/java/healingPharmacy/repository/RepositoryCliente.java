package healingPharmacy.repository;

import org.springframework.stereotype.Repository;

import healingPharmacy.model.Cliente;

@Repository
public class RepositoryCliente {
	public boolean validar(Cliente cliente) {
		return true;
	}
	
	
	public void persistir() {
		
	}
}
