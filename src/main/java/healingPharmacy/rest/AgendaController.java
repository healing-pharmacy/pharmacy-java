package healingPharmacy.rest;

import healingPharmacy.model.Agenda;
import healingPharmacy.model.Paciente;
import healingPharmacy.repository.IAgenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/agendas")
public class AgendaController {
    @Autowired
    private IAgenda agendaRepository;

    /*@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agenda salvar(@RequestBody Agenda agenda){
        return agendaRepository.save(agenda);
    }*/

    @GetMapping()
    public List<Agenda> list(){
        return agendaRepository.findAll();
    }

    /*@DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id){
        agendaRepository
                .findById(id)
                .map(agenda -> {
                    agendaRepository.delete(agenda);
                    return Void.TYPE;                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda não encontrada"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar (@PathVariable Integer id, @RequestBody @Valid Agenda agendaAtualizado){
        agendaRepository
                .findById(id)
                .map(agenda -> {
                    agendaAtualizado.setAgenda_id(agenda.getAgenda_id());
                    return agendaRepository.save(agenda);                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda não encontrada"));
    }*/
}
