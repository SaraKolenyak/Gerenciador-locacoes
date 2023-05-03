package br.com.gerenciadorlocacoes.controllers;

import br.com.gerenciadorlocacoes.services.ContratoService;
import br.com.gerenciadorlocacoes.domains.Contrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/contratos")
public class ContratoController {

    @Autowired
    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @PostMapping
    public void criarContrato (@RequestBody Contrato contrato){
        contratoService.criarContrato(contrato);
    }

    //Métodos idepotentes
    @PutMapping
    public void editarContrato (Contrato contrato){
        contratoService.editarContrato(contrato);
    }

    @DeleteMapping ("/{id}")
    public void removerContrato (@PathVariable("id") Long id){
        contratoService.removerContrato(id);
    }

    @GetMapping
    public List<Contrato> listarContratos(){
        return contratoService.listarContratos();
    }

    @GetMapping (value = "/{id}")
    public Contrato listarContrato(@PathVariable Long id){
        return contratoService.listarContrato(id);
    }
}
