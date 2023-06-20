package healingPharmacy.rest;

import healingPharmacy.model.Funcionario;
import healingPharmacy.model.Paciente;
import healingPharmacy.repository.IFuncionario;
import healingPharmacy.repository.IPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/funcionarios")
public class FuncionarioController {
    @Autowired
    private IFuncionario dao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario salvar(@RequestBody Funcionario funcionario){
        return dao.save(funcionario);
    }

    @GetMapping("/{funcionario_id}")
    public ResponseEntity<Funcionario> acharPorId (@PathVariable Integer funcionario_id ){
        return dao.findById(funcionario_id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{funcionario_id}")
    public ResponseEntity<Funcionario> atualizar (@PathVariable Integer funcionario_id, @RequestBody Funcionario funcionario){
        return dao.findById(funcionario_id)
                .map(recordFound -> {
                    recordFound.setNome_funcionario(funcionario.getNome_funcionario());
                    recordFound.setData_nascimento(funcionario.getData_nascimento());
                    recordFound.setCpf(funcionario.getCpf());
                    recordFound.setEndereco(funcionario.getEndereco());
                    recordFound.setTelefone(funcionario.getTelefone());
                    Funcionario atualizado = dao.save(recordFound);
                    return ResponseEntity.ok().body(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{funcionario_id}")
    public ResponseEntity<Void> deletar (@PathVariable Integer funcionario_id){
        return dao.findById(funcionario_id)
                .map(recordFound -> {
                    dao.deleteById(funcionario_id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping()
    public List<Funcionario> list(){
        return dao.findAll();
    }
}
