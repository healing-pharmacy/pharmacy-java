package healingPharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import healingPharmacy.model.Paciente;

public interface IPaciente extends JpaRepository<Paciente, Integer> {
}
