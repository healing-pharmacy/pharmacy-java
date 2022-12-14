package healingPharmacy.repository;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

import healingPharmacy.model.Cliente;

public interface IClientes extends CrudRepository<Cliente, Integer> {
}
