package br.com.gerenciadorlocacoes.services;
import br.com.gerenciadorlocacoes.domains.Contrato;
import br.com.gerenciadorlocacoes.domains.Imovel;
import br.com.gerenciadorlocacoes.domains.Locador;
import br.com.gerenciadorlocacoes.domains.Locatario;
import br.com.gerenciadorlocacoes.entities.ContratoEntity;
import br.com.gerenciadorlocacoes.entities.ImovelEntity;
import br.com.gerenciadorlocacoes.entities.LocadorEntity;
import br.com.gerenciadorlocacoes.entities.LocatarioEntity;
import br.com.gerenciadorlocacoes.repositories.ContratoRepository;
import br.com.gerenciadorlocacoes.repositories.ImovelRepository;
import br.com.gerenciadorlocacoes.repositories.LocadorRepository;
import br.com.gerenciadorlocacoes.repositories.LocatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContratoServiceImpl implements ContratoService {

    @Autowired
    private final ContratoRepository contratoRepository;

    @Autowired
    private final LocatarioRepository locatarioRepository;

    @Autowired
    private final LocadorRepository locadorRepository;

    @Autowired
    private final ImovelRepository imovelRepository;

    public ContratoServiceImpl(ContratoRepository contratoRepository, LocatarioRepository locatarioRepository, LocadorRepository locadorRepository, ImovelRepository imovelRepository) {
        this.contratoRepository = contratoRepository;
        this.locatarioRepository = locatarioRepository;
        this.locadorRepository = locadorRepository;
        this.imovelRepository = imovelRepository;
    }

    @Override
    public void criarContrato (Contrato contrato){

        LocatarioEntity locatarioEntity = new LocatarioEntity();
        locatarioEntity.setId(contrato.getLocatario().getId());
        locatarioEntity.setNome(contrato.getLocatario().getNome());
        locatarioEntity.setCelular(contrato.getLocatario().getCelular());

        LocadorEntity locadorEntity = new LocadorEntity();
        locadorEntity.setId(contrato.getImovel().getLocador().getId());
        locadorEntity.setNome(contrato.getImovel().getLocador().getNome());
        locadorEntity.setCelular(contrato.getImovel().getLocador().getCelular());

        ImovelEntity imovelEntity = new ImovelEntity();
        imovelEntity.setId(contrato.getImovel().getId());
        imovelEntity.setApelido(contrato.getImovel().getApelido());
        imovelEntity.setEndereco(contrato.getImovel().getEndereco());
        imovelEntity.setLocador(locadorEntity);

        ContratoEntity contratoEntity = new ContratoEntity();
        contratoEntity.setId(contrato.getId());
        contratoEntity.setDtContrato(contrato.getDtContrato());
        contratoEntity.setDiaVencimento(contrato.getDiaVencimento());
        contratoEntity.setPrazo(contrato.getDiaVencimento());
        contratoEntity.setValorAluguel(contrato.getValorAluguel());
        contratoEntity.setLocatario(locatarioEntity);
        contratoEntity.setImovel(imovelEntity);

        contratoRepository.save(contratoEntity);

    }

    @Override
    public void editarContrato (Long id, Contrato contrato){

        LocatarioEntity locatarioEntity = new LocatarioEntity();
        locatarioEntity.setId(contrato.getLocatario().getId());
        locatarioEntity.setNome(contrato.getLocatario().getNome());
        locatarioEntity.setCelular(contrato.getLocatario().getCelular());

        LocadorEntity locadorEntity = new LocadorEntity();
        locadorEntity.setId(contrato.getImovel().getLocador().getId());
        locadorEntity.setNome(contrato.getImovel().getLocador().getNome());
        locadorEntity.setCelular(contrato.getImovel().getLocador().getCelular());

        ImovelEntity imovelEntity = new ImovelEntity();
        imovelEntity.setId(contrato.getImovel().getId());
        imovelEntity.setApelido(contrato.getImovel().getApelido());
        imovelEntity.setEndereco(contrato.getImovel().getEndereco());
        imovelEntity.setLocador(locadorEntity);

        ContratoEntity contratoEntity = contratoRepository.findById(id).get();
        contratoEntity.setDtContrato(contrato.getDtContrato());
        contratoEntity.setDiaVencimento(contrato.getDiaVencimento());
        contratoEntity.setPrazo(contrato.getDiaVencimento());
        contratoEntity.setValorAluguel(contrato.getValorAluguel());
        contratoEntity.setLocatario(locatarioEntity);
        contratoEntity.setImovel(imovelEntity);

        contratoRepository.save(contratoEntity);
    }

    @Override
    public void removerContrato (Long id) {
        contratoRepository.deleteById(id);
    }

    @Override
    public List<Contrato> listarContratos(){
        List<ContratoEntity> entities = contratoRepository.findAll();
        List<Contrato> contratos = new ArrayList<>();
        for (ContratoEntity contratoEntity : entities) {

            Contrato contrato = new Contrato();

            LocatarioEntity locatarioEntity = contratoEntity.getLocatario();
            Locatario locatario = new Locatario();
            locatario.setId(locatarioEntity.getId());
            locatario.setNome(locatarioEntity.getNome());
            locatario.setCelular(locatarioEntity.getCelular());

            LocadorEntity locadorEntity = contratoEntity.getImovel().getLocador();
            Locador locador = new Locador();
            locador.setId(locadorEntity.getId());
            locador.setNome(locadorEntity.getNome());
            locador.setCelular(locadorEntity.getCelular());

            ImovelEntity imovelEntity = contratoEntity.getImovel();
            Imovel imovel = new Imovel();
            imovel.setId(imovelEntity.getId());
            imovel.setApelido(imovelEntity.getApelido());
            imovel.setEndereco(imovelEntity.getEndereco());
            imovel.setLocador(locador);

            contrato.setId(contratoEntity.getId());
            contrato.setPrazo(contratoEntity.getPrazo());
            contrato.setDtContrato(contratoEntity.getDtContrato());
            contrato.setValorAluguel(contratoEntity.getValorAluguel());
            contrato.setDiaVencimento(contratoEntity.getDiaVencimento());
            contrato.setLocatario(locatario);
            contrato.setImovel(imovel);

            contratos.add(contrato);
        }
        return contratos;
    }

    @Override
    public Contrato listarContrato(long id){

        ContratoEntity contratoEntity = contratoRepository.findById(id).get();

        Locador locador = new Locador();
        locador.setId(contratoEntity.getImovel().getLocador().getId());
        locador.setNome(contratoEntity.getImovel().getLocador().getNome());
        locador.setCelular(contratoEntity.getImovel().getLocador().getCelular());

        Imovel imovel = new Imovel();
        imovel.setId(contratoEntity.getImovel().getId());
        imovel.setApelido(contratoEntity.getImovel().getApelido());
        imovel.setEndereco(contratoEntity.getImovel().getEndereco());
        imovel.setLocador(locador);

        Locatario locatario = new Locatario();
        locatario.setId(contratoEntity.getLocatario().getId());
        locatario.setNome(contratoEntity.getLocatario().getNome());
        locatario.setCelular(contratoEntity.getLocatario().getCelular());

        Contrato contrato = new Contrato();
        contrato.setId(contratoEntity.getId());
        contrato.setPrazo(contratoEntity.getPrazo());
        contrato.setDtContrato(contratoEntity.getDtContrato());
        contrato.setValorAluguel(contratoEntity.getValorAluguel());
        contrato.setDiaVencimento(contratoEntity.getDiaVencimento());
        contrato.setLocatario(locatario);
        contrato.setImovel(imovel);

        return contrato;
    }
}
