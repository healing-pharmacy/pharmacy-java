package healingPharmacy.rest;

import healingPharmacy.model.Cliente;
import healingPharmacy.repository.ICliente;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/clientes")
@AllArgsConstructor
public class ClienteController {

    private final ICliente dao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody Cliente cliente){
        Cliente clienteNovo = dao.save(cliente);
        return clienteNovo;
    }

    @GetMapping("{id}")
    public Cliente acharPorId ( @PathVariable Integer id ){
        return dao
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id){
        dao
                .findById(id)
                .map( cliente -> {
                    dao.delete(cliente);
                    return Void.TYPE;                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar (@PathVariable Integer id, @RequestBody @Valid Cliente clienteAtualizado){
        dao
                .findById(id)
                .map( cliente -> {
                    clienteAtualizado.setCli_id(cliente.getCli_id());
                    return dao.save(cliente);                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @GetMapping
    public List<Cliente> list() {
        return dao.findAll();
    }
}
