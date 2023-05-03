package br.com.gerenciadorlocacoes.repositories;

import br.com.gerenciadorlocacoes.entities.ImovelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImovelRepository extends JpaRepository<ImovelEntity, Long> {

}
