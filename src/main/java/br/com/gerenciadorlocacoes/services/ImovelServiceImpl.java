package br.com.gerenciadorlocacoes.services;

import br.com.gerenciadorlocacoes.domains.Imovel;
import br.com.gerenciadorlocacoes.domains.Locador;
import br.com.gerenciadorlocacoes.entities.ImovelEntity;
import br.com.gerenciadorlocacoes.entities.LocadorEntity;
import br.com.gerenciadorlocacoes.repositories.ImovelRepository;
import br.com.gerenciadorlocacoes.repositories.LocadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImovelServiceImpl implements ImovelService {

    @Autowired
    private final ImovelRepository imovelRepository;

    @Autowired
    private final LocadorRepository locadorRepository;


    public ImovelServiceImpl(ImovelRepository imovelRepository, LocadorRepository locadorRepository) {
        this.imovelRepository = imovelRepository;
        this.locadorRepository = locadorRepository;
    }

    @Override
    public void criarImovel(Imovel imovel) {

        LocadorEntity locadorEntity = new LocadorEntity();
        locadorEntity.setId(imovel.getLocador().getId());
        locadorEntity.setNome(imovel.getLocador().getNome());
        locadorEntity.setCelular(imovel.getLocador().getCelular());

        ImovelEntity imovelEntity = new ImovelEntity();
        imovelEntity.setId(imovel.getId());
        imovelEntity.setApelido(imovel.getApelido());
        imovelEntity.setEndereco(imovel.getEndereco());
        imovelEntity.setLocador(locadorEntity);

        imovelRepository.save(imovelEntity);
    }

    @Override
    public void editarImovel(Long id, Imovel imovel) {

        ImovelEntity imovelEntity = imovelRepository.findById(id).get();

        LocadorEntity locadorEntity = new LocadorEntity();
        locadorEntity.setId(imovel.getLocador().getId());
        locadorEntity.setNome(imovel.getLocador().getNome());
        locadorEntity.setCelular(imovel.getLocador().getCelular());

        imovelEntity.setApelido(imovel.getApelido());
        imovelEntity.setEndereco(imovel.getEndereco());
        imovelEntity.setLocador(locadorEntity);

        imovelRepository.save(imovelEntity);
    }

    @Override
    public void removerImovel(Long id) {
        imovelRepository.deleteById(id);
    }

    @Override
    public List<Imovel> listarImoveis() {

        List<ImovelEntity> entities = imovelRepository.findAll();
        List<Imovel> imoveis = new ArrayList<>();
        for (ImovelEntity imovelEntity : entities) {

            Locador locador = new Locador();
            locador.setId(imovelEntity.getLocador().getId());
            locador.setNome(imovelEntity.getLocador().getNome());
            locador.setCelular(imovelEntity.getLocador().getCelular());

            Imovel imovel = new Imovel();
            imovel.setId(imovelEntity.getId());
            imovel.setApelido(imovelEntity.getApelido());
            imovel.setEndereco(imovelEntity.getEndereco());
            imovel.setLocador(locador);

            imoveis.add(imovel);
        }

        return imoveis;
    }

    @Override
    public Imovel listarImovel(long id) {

        ImovelEntity imovelEntity = imovelRepository.findById(id).get();

        Locador locador = new Locador();
        locador.setId(imovelEntity.getLocador().getId());
        locador.setNome(imovelEntity.getLocador().getNome());
        locador.setCelular(imovelEntity.getLocador().getCelular());

        Imovel imovel = new Imovel();
        imovel.setId(imovelEntity.getId());
        imovel.setApelido(imovelEntity.getApelido());
        imovel.setEndereco(imovelEntity.getEndereco());
        imovel.setLocador(locador);

        return imovel;
    }
}
