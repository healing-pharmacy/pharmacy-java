package healingPharmacy.rest;

import healingPharmacy.model.Cliente;
import healingPharmacy.repository.RepositoryCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class clienteController {

    private final RepositoryCliente repository;

    @Autowired
    public clienteController(RepositoryCliente repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar( @RequestBody Cliente cliente){
        return repository.save(cliente);
    }
}
