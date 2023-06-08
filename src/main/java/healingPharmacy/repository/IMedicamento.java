package healingPharmacy.repository;

import healingPharmacy.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicamento extends JpaRepository<Medicamento, Integer> {
}
