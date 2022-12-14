package healingPharmacy.rest;

import healingPharmacy.model.Usuario;
import healingPharmacy.repository.IUsuario;
//import healingPharmacy.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/usuarios")
public class UsuarioController  {
    //private final RepositoryUsuario repository;

    @Autowired
    private IUsuario dao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody Usuario usuario){
        Usuario usuarioNovo = dao.save(usuario);
        return usuarioNovo;
    }

    @GetMapping("{id}")
    public Usuario acharPorId (@PathVariable Integer id ){
        return dao
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id){
        dao
                .findById(id)
                .map( usuario -> {
                    dao.delete(usuario);
                    return Void.TYPE;                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar (@PathVariable Integer id, @RequestBody @Valid Usuario  usuarioAtualizado){
        Usuario usuarioEditado = dao.save(usuarioAtualizado);
        dao
                .findById(id)
                .map( usuario -> {
                    usuarioAtualizado.setUsu_id(usuario.getUsu_id());
                    return dao.save(usuario);                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));
    }
}
