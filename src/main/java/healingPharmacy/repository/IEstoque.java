package healingPharmacy.repository;

import healingPharmacy.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstoque extends JpaRepository<Estoque, Integer> {
}
