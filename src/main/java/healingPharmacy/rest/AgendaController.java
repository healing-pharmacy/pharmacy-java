package healingPharmacy.rest;

import healingPharmacy.model.Agenda;
import healingPharmacy.repository.IAgenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/agenda")
public class AgendaController {
    @Autowired
    private IAgenda dao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agenda salvar(@RequestBody Agenda agenda){
        return dao.save(agenda);
    }

    @GetMapping("{id}")
    public Agenda acharPorId (@PathVariable Integer id ){
        return dao
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id){
        dao
                .findById(id)
                .map(agenda -> {
                    dao.delete(agenda);
                    return Void.TYPE;                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda não encontrada"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar (@PathVariable Integer id, @RequestBody @Valid Agenda agendaAtualizado){
        dao
                .findById(id)
                .map(agenda -> {
                    agendaAtualizado.setAgenda_id(agenda.getAgenda_id());
                    return dao.save(agenda);                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda não encontrada"));
    }
}
