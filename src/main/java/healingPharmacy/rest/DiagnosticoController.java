package healingPharmacy.rest;


import healingPharmacy.model.Diagnostico;
import healingPharmacy.model.Paciente;
import healingPharmacy.repository.IDiagnostico;
import healingPharmacy.repository.IPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/diagnostico")
public class DiagnosticoController {
    @Autowired
    private IDiagnostico dao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Diagnostico salvar(@RequestBody Diagnostico diagnostico){
        Diagnostico diagnosticoNovo = dao.save(diagnostico);
        return diagnosticoNovo;
    }

    @GetMapping("{id}")
    public Diagnostico acharPorId (@PathVariable Integer id ){
        return dao
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id){
        dao
                .findById(id)
                .map(diagnostico -> {
                    dao.delete(diagnostico);
                    return Void.TYPE;                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Diagnóstico não encontrado"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar (@PathVariable Integer id, @RequestBody @Valid Diagnostico diagnosticoAtualizado){
        dao
                .findById(id)
                .map(diagnostico -> {
                    diagnosticoAtualizado.setDiagnostico_id(diagnostico.getDiagnostico_id());
                    return dao.save(diagnostico);                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Diagnóstico não encontrado"));
    }

    @GetMapping("/all")
    public List<Diagnostico> list(){
        return dao.findAll();
    }
}
