package br.com.gerenciadorlocacoes.services;

import br.com.gerenciadorlocacoes.domains.Locador;
import br.com.gerenciadorlocacoes.domains.Locatario;
import br.com.gerenciadorlocacoes.entities.LocadorEntity;
import br.com.gerenciadorlocacoes.entities.LocatarioEntity;
import br.com.gerenciadorlocacoes.repositories.LocatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocatarioServiceImpl implements LocatarioService {

    @Autowired
    private final LocatarioRepository locatarioRepository;

    public LocatarioServiceImpl(LocatarioRepository locatarioRepository) {
        this.locatarioRepository = locatarioRepository;
    }

    @Override
    public void criarLocatario (Locatario locatario){

        LocatarioEntity locatarioEntity = new LocatarioEntity();

        locatarioEntity.setId(locatario.getId());
        locatarioEntity.setNome(locatario.getNome());
        locatarioEntity.setCelular(locatario.getCelular());

        locatarioRepository.save(locatarioEntity);
    }

    @Override
    public void editarLocatario (Locatario locatario){}

    @Override
    public void removerLocatario (Long id){
        locatarioRepository.deleteById(id);
    }

    @Override
    public List<Locatario> listarLocatarios(){

        List<LocatarioEntity> entities = locatarioRepository.findAll();
        List<Locatario> locatarios = new ArrayList<>();
        for (LocatarioEntity locatarioEntity : entities) {

            Locatario locatario = new Locatario();
            locatario.setId(locatarioEntity.getId());
            locatario.setNome(locatarioEntity.getNome());
            locatario.setCelular(locatarioEntity.getCelular());

            locatarios.add(locatario);
        }

        return locatarios;
    }

    @Override
    public Locatario listarLocatario(long id){

        LocatarioEntity locatarioEntity = locatarioRepository.findById(id).get();

        Locatario locatario = new Locatario();
        locatario.setId(locatarioEntity.getId());
        locatario.setNome(locatarioEntity.getNome());
        locatario.setCelular(locatarioEntity.getCelular());

        return locatario;
    }

}
