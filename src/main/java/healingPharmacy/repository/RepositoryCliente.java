package healingPharmacy.repository;

import org.springframework.stereotype.Repository;

import healingPharmacy.model.ModelCliente;

@Repository
public class RepositoryCliente {
	public boolean validar(ModelCliente cliente) {
		return true;
	}
	
	
	public void persistir() {
		
	}
}
