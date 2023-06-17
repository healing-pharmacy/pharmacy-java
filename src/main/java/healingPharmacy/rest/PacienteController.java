package healingPharmacy.rest;

import healingPharmacy.model.Paciente;
import healingPharmacy.repository.IPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/pacientes")
public class PacienteController {
    @Autowired
    private IPaciente dao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente salvar(@RequestBody Paciente paciente){
        //System.out.println(paciente.getNome_paciente());
        return dao.save(paciente);
    }

    @GetMapping("/{id_paciente}")
    public ResponseEntity<Paciente> acharPorId (@PathVariable Integer id_paciente ){
        return dao.findById(id_paciente)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());

                //.findById(id)
                //.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id_paciente}")
    public ResponseEntity<Paciente> atualizar (@PathVariable Integer id_paciente, @RequestBody Paciente paciente){
        return dao.findById(id_paciente)
                .map(recordFound -> {
                    recordFound.setNome_paciente(paciente.getNome_paciente());
                    recordFound.setData_nascimento(paciente.getData_nascimento());
                    recordFound.setEmail(paciente.getEmail());
                    recordFound.setCpf(paciente.getCpf());
                    recordFound.setEndereco(paciente.getEndereco());
                    recordFound.setTelefone(paciente.getTelefone());
                    Paciente atualizado = dao.save(recordFound);
                    return ResponseEntity.ok().body(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());

                /*.findById(id_paciente)
                .map(paciente -> {
                    pacienteAtualizado.setId_paciente(paciente.getId_paciente());
                    return dao.save(paciente);                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));*/
    }

    @DeleteMapping("/{id_paciente}")
    public ResponseEntity<Void> deletar (@PathVariable Integer id_paciente){
        return dao.findById(id_paciente)
                .map(recordFound -> {
                    dao.deleteById(id_paciente);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());

                /*.findById(id_paciente)
                .map(paciente -> {
                    dao.delete(paciente);
                    return Void.TYPE;                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));*/

    }

    @GetMapping()
    public List<Paciente> list(){
        return dao.findAll();
    }
}
