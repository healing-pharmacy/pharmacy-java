package healingPharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import healingPharmacy.model.Usuario;
import healingPharmacy.repository.RepositoryUsuario;

@Service
public class ServiceCadastroUsuario {
	
	private RepositoryUsuario repository;
	
	@Autowired
	public ServiceCadastroUsuario (RepositoryUsuario repository) {
		this.repository = repository;
	}
	
	public void salvarUsuario (Usuario usuario) {
		this.repository.validar(usuario);
		this.repository.persistir();
	}
}
