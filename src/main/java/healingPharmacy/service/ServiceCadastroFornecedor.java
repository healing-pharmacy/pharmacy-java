package healingPharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import healingPharmacy.model.ModelFornecedor;
import healingPharmacy.repository.RepositoryFornecedor;

@Service
public class ServiceCadastroFornecedor {
	
	private RepositoryFornecedor repository;
	
	@Autowired
	public ServiceCadastroFornecedor (RepositoryFornecedor repository) {
		this.repository = repository;
	}
	
	public void salvarFornecedor (ModelFornecedor fornecedor) {
		this.repository.validar(fornecedor);
		this.repository.persistir();
	}
}
