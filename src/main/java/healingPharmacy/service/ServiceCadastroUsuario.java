package healingPharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import healingPharmacy.model.ModelUsuario;
import healingPharmacy.repository.RepositoryUsuario;

@Service
public class ServiceCadastroUsuario {
	
	private RepositoryUsuario repository;
	
	@Autowired
	public ServiceCadastroUsuario (RepositoryUsuario repository) {
		this.repository = repository;
	}
	
	public void salvarUsuario (ModelUsuario usuario) {
		this.repository.validar(usuario);
		this.repository.persistir();
	}
}
