package br.com.gerenciadorlocacoes.services;

import br.com.gerenciadorlocacoes.domains.Locador;

import java.util.List;

public interface LocadorService {

    void criarLocador (Locador locador);
    void editarLocador(Long id, Locador locador);
    void removerLocador (Long id);
    List<Locador> listarLocadores();
    Locador listarLocador(long id);
}
