package healingPharmacy.rest;

import healingPharmacy.model.Fornecedor;
import healingPharmacy.repository.IFornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController {
    private final IFornecedor repository;

    @Autowired
    public FornecedorController(IFornecedor repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fornecedor salvar(@RequestBody Fornecedor fornecedor){
        return repository.save(fornecedor);
    }

    @GetMapping("{id}")
    public Fornecedor acharPorId (@PathVariable Integer id ){
        return repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id){
        repository
                .findById(id)
                .map( fornecedor -> {
                    repository.delete(fornecedor);
                    return Void.TYPE;                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar (@PathVariable Integer id, @RequestBody @Valid Fornecedor fornecedorAtualizado){
        repository
                .findById(id)
                .map( fornecedor -> {
                    fornecedorAtualizado.setForn_id(fornecedor.getForn_id());
                    return repository.save(fornecedor);                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não encontrado"));
    }
}
