package br.com.gerenciadorlocacoes.repositories;

import br.com.gerenciadorlocacoes.entities.LocatarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocatarioRepository extends JpaRepository<LocatarioEntity, Long> {


}
