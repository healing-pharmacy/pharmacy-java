package healingPharmacy.repository;

import healingPharmacy.model.Agenda;
import healingPharmacy.model.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDiagnostico extends JpaRepository<Diagnostico, Integer> {
}
