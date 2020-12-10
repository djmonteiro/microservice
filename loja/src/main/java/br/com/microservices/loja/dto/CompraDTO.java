package br.com.microservices.loja.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CompraDTO {
    private List<ItensDaCompraDTO> itens;
    private EnderecoDTO endereco;
}
