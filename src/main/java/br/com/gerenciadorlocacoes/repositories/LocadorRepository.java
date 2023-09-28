package br.com.gerenciadorlocacoes.repositories;

import br.com.gerenciadorlocacoes.domains.Locador;
import br.com.gerenciadorlocacoes.entities.LocadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocadorRepository extends JpaRepository<LocadorEntity, Long> {


}
