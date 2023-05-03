package br.com.gerenciadorlocacoes.controllers;

import br.com.gerenciadorlocacoes.services.ImovelService;
import br.com.gerenciadorlocacoes.domains.Imovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/imoveis")
public class ImovelController {

    @Autowired
    private final ImovelService imovelService;

    public ImovelController(ImovelService imovelService) {
        this.imovelService = imovelService;
    }

    @PostMapping
    public void criarImovel(@RequestBody Imovel imovel){
        imovelService.criarImovel(imovel);
    }

    @PutMapping
    public void editarImovel(Imovel imovel){
        imovelService.editarImovel(imovel);
    }

    @DeleteMapping ("/{id}")
    public void removerImovel(@PathVariable("id") Long id){
        imovelService.removerImovel(id);
    }

    @GetMapping
    public List<Imovel> listarImoveis(){
        return imovelService.listarImoveis();
    }

    @GetMapping (value = "/{id}")
    public Imovel listarImovel(@PathVariable Long id){
        return imovelService.listarImovel(id);
    }
}
