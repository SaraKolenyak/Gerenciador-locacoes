package br.com.gerenciadorlocacoes.services;

import br.com.gerenciadorlocacoes.domains.Locatario;
import java.util.List;

public interface LocatarioService {

    void criarLocatario (Locatario locatario);
    void editarLocatario (Locatario locatario);
    void removerLocatario (Long id);
    List<Locatario> listarLocatarios();
    Locatario listarLocatario(long id);


}
