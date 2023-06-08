package healingPharmacy.rest;

import healingPharmacy.model.Responsavel;

import healingPharmacy.repository.IResponsavel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/funcionario")
public class ResponsavelController {

    @Autowired
    private IResponsavel dao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Responsavel salvar(@RequestBody Responsavel responsavel) {
        Responsavel responsavelNovo = dao.save(responsavel);
        return responsavelNovo;
    }

    @GetMapping("{id}")
    public Responsavel acharPorId (@PathVariable Integer id ){
        return dao
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id){
        dao
                .findById(id)
                .map(responsavel -> {
                    dao.delete(responsavel);
                    return Void.TYPE;                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar (@PathVariable Integer id, @RequestBody @Valid Responsavel responsavelAtualizado){
        dao
                .findById(id)
                .map(responsavel -> {
                    responsavelAtualizado.setResponsavel_id(responsavel.getResponsavel_id());
                    return dao.save(responsavel);                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));
    }
}
