package br.com.microservices.loja.service;

import br.com.microservices.loja.dto.CompraDTO;
import br.com.microservices.loja.model.Compra;

public interface CompraService {

    Compra realizaCompra(CompraDTO compraDTO);

}
