package healingPharmacy.repository;

import healingPharmacy.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAgenda extends JpaRepository<Agenda, Integer> {
}
