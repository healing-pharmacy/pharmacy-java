package healingPharmacy.repository;

import healingPharmacy.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutos extends CrudRepository<Produto, Integer> {
}
