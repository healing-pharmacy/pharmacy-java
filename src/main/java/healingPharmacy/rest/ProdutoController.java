package healingPharmacy.rest;

import healingPharmacy.model.Produto;
import healingPharmacy.repository.RespositoryProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final RespositoryProduto repository;

    @Autowired
    public ProdutoController(RespositoryProduto repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto salvar(@RequestBody @Valid Produto produto){
        return repository.save(produto);
    }

    @GetMapping("{id}")
    public Produto acharPorId (@PathVariable Integer id ){
        return repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id){
        repository
                .findById(id)
                .map( produto -> {
                    repository.delete(produto);
                    return Void.TYPE;                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar (@PathVariable Integer id, @RequestBody @Valid Produto produtoAtualizado){
        repository
                .findById(id)
                .map( produto -> {
                    produtoAtualizado.setProd_id(produto.getProd_id());
                    return repository.save(produto);                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }
}
