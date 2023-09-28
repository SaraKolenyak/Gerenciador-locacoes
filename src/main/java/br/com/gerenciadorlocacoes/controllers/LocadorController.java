package br.com.gerenciadorlocacoes.controllers;

import br.com.gerenciadorlocacoes.domains.Locador;
import br.com.gerenciadorlocacoes.services.LocadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/locadores")
public class LocadorController {

    @Autowired
    private final LocadorService locadorService;

    public LocadorController(LocadorService locadorService) {
        this.locadorService = locadorService;
    }

    @PostMapping
    public void criarLocador (@RequestBody Locador locador){
        locadorService.criarLocador(locador);
    }

    @PutMapping ("/{id}")
    public void editarLocador (@PathVariable("id") Long id, @RequestBody Locador locador){
        locadorService.editarLocador(id,locador);

    }

    @DeleteMapping ("/{id}")
    public void removerLocador (@PathVariable("id") Long id){
        locadorService.removerLocador(id);
    }

    @GetMapping
    public List<Locador> listarLocadores(){
        return locadorService.listarLocadores();
    }

    @GetMapping (value = "/{id}")
    public Locador listarLocador(@PathVariable Long id){
        return locadorService.listarLocador(id);
    }
}
