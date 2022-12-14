package healingPharmacy.repository;

import healingPharmacy.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProduto extends JpaRepository<Produto, Integer> {
}
