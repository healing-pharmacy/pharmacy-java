package healingPharmacy.repository;

import org.springframework.stereotype.Repository;


import healingPharmacy.model.Venda;

@Repository
public class RepositoryVenda {
	public boolean validar(Venda venda) {
		return true;
	}
	
	
	public void persistir() {
		
	}
}
