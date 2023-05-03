package br.com.gerenciadorlocacoes.services;

import br.com.gerenciadorlocacoes.domains.Locador;
import br.com.gerenciadorlocacoes.entities.LocadorEntity;
import br.com.gerenciadorlocacoes.repositories.LocadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocadorServiceImpl implements LocadorService {

    @Autowired
    private final LocadorRepository locadorRepository;

    public LocadorServiceImpl(LocadorRepository locadorRepository) {
        this.locadorRepository = locadorRepository;
    }

    @Override
    public void criarLocador (Locador locador){

        LocadorEntity locadorEntity = new LocadorEntity();

        locadorEntity.setId(locador.getId());
        locadorEntity.setNome(locador.getNome());
        locadorEntity.setCelular(locador.getCelular());

        locadorRepository.save(locadorEntity);
    }

    @Override
    public void editarLocador (Locador locador){}

    @Override
    public void removerLocador (Long id){
        locadorRepository.deleteById(id);
    }

    @Override
    public List<Locador> listarLocadores(){

        List<LocadorEntity> entities = locadorRepository.findAll();
        List<Locador> locadores = new ArrayList<>();
        for (LocadorEntity locadorEntity : entities) {

            Locador locador = new Locador();
            locador.setId(locadorEntity.getId());
            locador.setNome(locadorEntity.getNome());
            locador.setCelular(locadorEntity.getCelular());

            locadores.add(locador);
        }

        return locadores;
    }

    @Override
    public Locador listarLocador(long id){

        LocadorEntity locadorEntity = locadorRepository.findById(id).get();

        Locador locador = new Locador();
        locador.setId(locadorEntity.getId());
        locador.setNome(locadorEntity.getNome());
        locador.setCelular(locadorEntity.getCelular());

        return locador;
    }


}
