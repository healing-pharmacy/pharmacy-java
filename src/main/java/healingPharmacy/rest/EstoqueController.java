package healingPharmacy.rest;

import healingPharmacy.model.Paciente;
import healingPharmacy.repository.IPaciente;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/pacientes")
@AllArgsConstructor
public class EstoqueController {

    private final IPaciente dao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente salvar(@RequestBody Paciente cliente){
        Paciente clienteNovo = dao.save(cliente);
        return clienteNovo;
    }

    @GetMapping("{id}")
    public Paciente acharPorId ( @PathVariable Integer id ){
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
    public void atualizar (@PathVariable Integer id, @RequestBody @Valid Paciente clienteAtualizado){
        dao
                .findById(id)
                .map( cliente -> {
                    clienteAtualizado.setCli_id(cliente.getCli_id());
                    return dao.save(cliente);                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @GetMapping
    public List<Paciente> list() {
        return dao.findAll();
    }
}
