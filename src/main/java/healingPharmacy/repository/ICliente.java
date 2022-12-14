package healingPharmacy.repository;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

import healingPharmacy.model.Cliente;

public interface ICliente extends CrudRepository<Cliente, Integer> {
}
