package healingPharmacy.repository;

import org.springframework.stereotype.Repository;


import healingPharmacy.model.ModelVenda;

@Repository
public class RepositoryVenda {
	public boolean validar(ModelVenda venda) {
		return true;
	}
	
	
	public void persistir() {
		
	}
}
