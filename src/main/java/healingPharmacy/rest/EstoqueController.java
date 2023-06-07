package healingPharmacy.rest;

import healingPharmacy.model.Estoque;
import healingPharmacy.repository.IEstoque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/produtos")
public class EstoqueController {

    @Autowired
    private IEstoque dao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estoque salvar(@RequestBody Estoque estoque) {
        Estoque estoqueNovo = dao.save(estoque);
        return estoqueNovo;
    }

    @GetMapping("{id}")
    public Estoque acharPorId (@PathVariable Integer id ){
        return dao
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id){
        dao
                .findById(id)
                .map(estoque -> {
                    dao.delete(estoque);
                    return Void.TYPE;                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar (@PathVariable Integer id, @RequestBody @Valid Estoque estoqueAtualizado){
        dao
                .findById(id)
                .map(estoque -> {
                    estoqueAtualizado.setProd_id(estoque.getProd_id());
                    return dao.save(estoque);                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }
}
