package healingPharmacy.repository;

import healingPharmacy.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProduto extends CrudRepository<Produto, Integer> {
}
