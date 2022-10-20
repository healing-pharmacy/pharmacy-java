package healingPharmacy.repository;

import org.springframework.stereotype.Repository;

import healingPharmacy.model.ModelUsuario;



@Repository
public class RepositoryUsuario {
		
	public boolean validar(ModelUsuario usuario) {
		return true;
	}
	
	
	public void persistir() {
		
	}
}
