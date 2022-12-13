package healingPharmacy.repository;

import healingPharmacy.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProduto extends JpaRepository <Produto, Integer> {
}
