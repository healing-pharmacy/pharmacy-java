package healingPharmacy.rest;

import healingPharmacy.model.Usuario;
import healingPharmacy.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final RepositoryUsuario repository;

    @Autowired
    public UsuarioController(RepositoryUsuario repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody Usuario usuario){
        return repository.save(usuario);
    }

    @GetMapping("{id}")
    public Usuario acharPorId (@PathVariable Integer id ){
        return repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id){
        repository
                .findById(id)
                .map( usuario -> {
                    repository.delete(usuario);
                    return Void.TYPE;                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar (@PathVariable Integer id, @RequestBody @Valid Usuario  usuarioAtualizado){
        repository
                .findById(id)
                .map( usuario -> {
                    usuarioAtualizado.setUsu_id(usuario.getUsu_id());
                    return repository.save(usuario);                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));
    }
}
