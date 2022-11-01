package healingPharmacy.repository;

import org.springframework.stereotype.Repository;

import healingPharmacy.model.Produto;

@Repository
public class RepositoryProduto {
	public boolean validar(Produto produto) {
		return true;
	}
	
	
	public void persistir() {
		
	}
}
