package br.com.microservices.fornecedor.service;

import br.com.microservices.fornecedor.model.InfoFornecedor;
import br.com.microservices.fornecedor.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService{

    @Autowired
    InfoRepository infoRepository;

    @Override
    public List<InfoFornecedor> getInfoTodos() {
        return infoRepository.findAll();
    }

    @Override
    public InfoFornecedor getInfoPorEstado(String estado) {
        return infoRepository.findByEstado(estado).orElseThrow(RuntimeException::new);
    }


}
