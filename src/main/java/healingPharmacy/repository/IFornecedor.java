package healingPharmacy.repository;

import healingPharmacy.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface IFornecedor extends JpaRepository<Fornecedor, Integer> {
}
