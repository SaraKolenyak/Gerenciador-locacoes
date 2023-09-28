package br.com.gerenciadorlocacoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.gerenciadorlocacoes.services.LocatarioService;
import br.com.gerenciadorlocacoes.domains.Locatario;
import java.util.List;

@RestController
@RequestMapping(value = "/locatarios")
public class LocatarioController {

    @Autowired
    private final LocatarioService locatarioService;

    public LocatarioController(LocatarioService locatarioService) {
        this.locatarioService = locatarioService;
    }

    @PostMapping
    public void criarLocatario (@RequestBody Locatario locatario){
        locatarioService.criarLocatario(locatario);
    }

    @PutMapping ("/{id}")
    public void editarLocatario (@PathVariable("id") Long id, @RequestBody Locatario locatario){
        locatarioService.editarLocatario(id,locatario);
    }

    @DeleteMapping ("/{id}")
    public void removerLocatario (@PathVariable("id") Long id){
        locatarioService.removerLocatario(id);
    }

    @GetMapping
    public List<Locatario> listarLocatarios(){
        return locatarioService.listarLocatarios();
    }

    @GetMapping (value = "/{id}")
    public Locatario listarLocatario( @PathVariable Long id ){
        return locatarioService.listarLocatario(id);
    }
}
