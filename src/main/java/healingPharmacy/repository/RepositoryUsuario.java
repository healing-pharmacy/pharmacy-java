package healingPharmacy.repository;

import org.springframework.stereotype.Repository;

import healingPharmacy.model.Usuario;



@Repository
public class RepositoryUsuario {
		
	public boolean validar(Usuario usuario) {
		return true;
	}
	
	
	public void persistir() {
		
	}
}
