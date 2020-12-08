package br.com.microservices.loja.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InfoFornecedorDTO {
    private String nome;
    private String endereco;
    private String estado;
}
