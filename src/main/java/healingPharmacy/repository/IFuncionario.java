package healingPharmacy.repository;

import healingPharmacy.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFuncionario extends JpaRepository<Funcionario, Integer> {
}
