package healingPharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import healingPharmacy.model.Cliente;
import healingPharmacy.repository.RepositoryCliente;

@Service
public class ServiceCadastroCliente {
		
	private RepositoryCliente repository;
	
	@Autowired
	public ServiceCadastroCliente (RepositoryCliente repository) {
		this.repository = repository;
	}
	
	public void salvarcliente (Cliente cliente) {
		this.repository.validar(cliente);
		this.repository.persistir();
	}
}
