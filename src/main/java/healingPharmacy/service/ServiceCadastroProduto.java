package healingPharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import healingPharmacy.model.ModelProduto;
import healingPharmacy.repository.RepositoryProduto;


@Service
public class ServiceCadastroProduto {

	private RepositoryProduto repository;
	
	@Autowired
	public ServiceCadastroProduto (RepositoryProduto repository) {
		this.repository = repository;
	}
	
	public void salvarProduto (ModelProduto produto) {
		this.repository.validar(produto);
		this.repository.persistir();
	}
}
