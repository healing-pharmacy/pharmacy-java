package healingPharmacy.repository;

import healingPharmacy.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
public interface IUsuario extends CrudRepository<Usuario, Integer> {
}
