package br.com.gerenciadorlocacoes.services;

import java.util.List;
import br.com.gerenciadorlocacoes.domains.Imovel;

public interface ImovelService {

    void criarImovel(Imovel imovel);
    void editarImovel(Imovel imovel);
    void removerImovel(Long id);
    List<Imovel> listarImoveis();
    Imovel listarImovel(long id);
}
