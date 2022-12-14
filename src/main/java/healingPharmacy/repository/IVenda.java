package healingPharmacy.repository;

import healingPharmacy.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IVenda extends CrudRepository<Venda, Integer> {
}
