package healingPharmacy.rest;

import healingPharmacy.model.Fornecedor;

import healingPharmacy.repository.IFornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/fornecedor")
public class FornecedorController {

    @Autowired
    private IFornecedor dao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fornecedor salvar(@RequestBody Fornecedor fornecedor) {
        Fornecedor fornecedorNovo = dao.save(fornecedor);
        return fornecedorNovo;
    }

    @GetMapping("{id}")
    public Fornecedor acharPorId (@PathVariable Integer id ){
        return dao
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id){
        dao
                .findById(id)
                .map( fornecedor -> {
                    dao.delete(fornecedor);
                    return Void.TYPE;                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar (@PathVariable Integer id, @RequestBody @Valid Fornecedor fornecedorAtualizado){
        dao
                .findById(id)
                .map( fornecedor -> {
                    fornecedorAtualizado.setForn_id(fornecedor.getForn_id());
                    return dao.save(fornecedor);                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));
    }
}
