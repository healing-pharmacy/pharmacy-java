package healingPharmacy.rest;

import healingPharmacy.model.Paciente;
import healingPharmacy.repository.IPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        Paciente pacienteNovo = dao.save(paciente);
        return pacienteNovo;
    }

    @GetMapping("{id}")
    public Paciente acharPorId (@PathVariable Integer id ){
        return dao
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id){
        dao
                .findById(id)
                .map(paciente -> {
                    dao.delete(paciente);
                    return Void.TYPE;                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar (@PathVariable Integer id, @RequestBody @Valid Paciente pacienteAtualizado){
        dao
                .findById(id)
                .map(paciente -> {
                    pacienteAtualizado.setId_paciente(paciente.getId_paciente());
                    return dao.save(paciente);                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Paciente não encontrado"));
    }

    @GetMapping("/all")
    public List<Paciente> list(){
        return dao.findAll();
    }
}
