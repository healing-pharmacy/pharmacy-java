package healingPharmacy.rest;

import healingPharmacy.model.Agenda;
import healingPharmacy.model.Paciente;
import healingPharmacy.repository.IAgenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agenda salvar(@RequestBody Agenda agenda){
        return agendaRepository.save(agenda);
    }

    @GetMapping()
    public List<Agenda> list(){
        return agendaRepository.findAll();
    }

    @DeleteMapping("/{agenda_id}")
    public ResponseEntity<Void> deletar (@PathVariable Integer agenda_id){
        return agendaRepository.findById(agenda_id)
                .map(recordFound -> {
                    agendaRepository.deleteById(agenda_id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{agenda_id}")
    public ResponseEntity<Agenda> atualizar (@PathVariable Integer agenda_id, @RequestBody Agenda agenda){
        return agendaRepository.findById(agenda_id)
                .map(recordFound -> {
                    recordFound.setResponsavel(agenda.getResponsavel());
                    recordFound.setDia(agenda.getDia());
                    recordFound.setMes(agenda.getMes());
                    recordFound.setAno(agenda.getAno());
                    recordFound.setConcluido(agenda.getConcluido());
                    recordFound.setTarefa(agenda.getTarefa());
                    recordFound.setNome_paciente(agenda.getNome_paciente());
                    Agenda atualizado = agendaRepository.save(recordFound);
                    return ResponseEntity.ok().body(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{agenda_id}")
    public ResponseEntity<Agenda> acharPorId (@PathVariable Integer agenda_id ){
        return agendaRepository.findById(agenda_id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
}
