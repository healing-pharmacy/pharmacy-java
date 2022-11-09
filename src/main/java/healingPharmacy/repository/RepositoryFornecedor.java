package healingPharmacy.repository;

import healingPharmacy.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryFornecedor extends JpaRepository <Fornecedor, Integer> {
}
