package healingPharmacy.rest;

import healingPharmacy.model.Medicamento;
import healingPharmacy.model.Paciente;
import healingPharmacy.repository.IMedicamento;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/medicamento")
@AllArgsConstructor
public class MedicamentoController {

    private final IMedicamento dao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medicamento salvar(@RequestBody Medicamento medicamento){
        Medicamento medicamentoNovo = dao.save(medicamento);
        return medicamentoNovo;
    }

    @GetMapping("{id}")
    public Medicamento acharPorId ( @PathVariable Integer id ){
        return dao
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id){
        dao
                .findById(id)
                .map( medicamento -> {
                    dao.delete(medicamento);
                    return Void.TYPE;                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicamento não encontrado"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar (@PathVariable Integer id, @RequestBody @Valid Medicamento medicamentoAtualizado){
        dao
                .findById(id)
                .map( paciente -> {
                    medicamentoAtualizado.setMedicamento_id(paciente.getMedicamento_id());
                    return dao.save(paciente);                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicamento não encontrado"));
    }

    @GetMapping
    public List<Medicamento> list() {
        return dao.findAll();
    }
}
