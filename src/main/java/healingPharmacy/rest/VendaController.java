package healingPharmacy.rest;

import healingPharmacy.model.Venda;
import healingPharmacy.repository.IUsuario;
import healingPharmacy.repository.IVenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/vendas")
public class VendaController {
    @Autowired
    private IVenda dao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Venda salvar(@RequestBody Venda venda){
        return dao.save(venda);
    }

    @GetMapping("{id}")
    public Venda acharPorId (@PathVariable Integer id ){
        return dao
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id){
        dao
                .findById(id)
                .map( venda -> {
                    dao.delete(venda);
                    return Void.TYPE;                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda não encontrada"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar (@PathVariable Integer id, @RequestBody @Valid Venda  vendaAtualizado){
        dao
                .findById(id)
                .map( venda -> {
                    vendaAtualizado.setVenda_id(venda.getVenda_id());
                    return dao.save(venda);                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Venda não encontrada"));
    }
}
