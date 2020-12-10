package br.com.microservices.fornecedor.service;

import br.com.microservices.fornecedor.model.InfoFornecedor;

import java.util.List;

public interface InfoService {
    List<InfoFornecedor> getInfoTodos();
    InfoFornecedor getInfoPorEstado(String estado);
}
