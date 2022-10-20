package healingPharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import healingPharmacy.model.ModelVenda;
import healingPharmacy.repository.RepositoryVenda;

@Service
public class ServiceVenda {
	private RepositoryVenda repository;
	
	@Autowired
	public ServiceVenda (RepositoryVenda repository) {
		this.repository = repository;
	}
	
	public void salvarVenda (ModelVenda produto) {
		this.repository.validar(produto);
		this.repository.persistir();
	}
}
