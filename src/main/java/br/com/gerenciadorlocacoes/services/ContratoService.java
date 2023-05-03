package br.com.gerenciadorlocacoes.services;

import java.util.List;
import br.com.gerenciadorlocacoes.domains.Contrato;

public interface ContratoService {

    void criarContrato (Contrato contrato);
    void editarContrato (Contrato contrato);
    void removerContrato (Long id);
    List<Contrato> listarContratos();
    Contrato listarContrato(long id);
}
