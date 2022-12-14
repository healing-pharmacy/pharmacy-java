package healingPharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import healingPharmacy.model.Cliente;

public interface ICliente extends JpaRepository<Cliente, Integer> {
}
