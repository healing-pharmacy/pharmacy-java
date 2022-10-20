package healingPharmacy.repository;

import org.springframework.stereotype.Repository;

import healingPharmacy.model.ModelProduto;

@Repository
public class RepositoryProduto {
	public boolean validar(ModelProduto produto) {
		return true;
	}
	
	
	public void persistir() {
		
	}
}
