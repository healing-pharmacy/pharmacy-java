package healingPharmacy.rest;

import healingPharmacy.model.Usuario;
import healingPharmacy.repository.IUsuario;
import healingPharmacy.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/usuarios")
public class UsuarioController  {

    @Autowired
    private IUsuario dao;

    private UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
        return ResponseEntity.status(201).body(usuarioService.criarUsuario(usuario));
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>> listaUsuarios(){
        return ResponseEntity.status(200).body(usuarioService.listarUsuario());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> excluirUsuario(@PathVariable Integer id){
        dao.deleteById(id);
        return ResponseEntity.status(204).build();
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
