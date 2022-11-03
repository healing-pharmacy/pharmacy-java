package healingPharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import healingPharmacy.model.Cliente;

@Repository
public interface RepositoryCliente extends JpaRepository <Cliente, Integer>{
}
