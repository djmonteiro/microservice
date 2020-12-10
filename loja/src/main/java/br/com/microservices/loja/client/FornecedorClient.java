package br.com.microservices.loja.client;

import br.com.microservices.loja.dto.InfoPedidoDTO;
import br.com.microservices.loja.dto.ItensDaCompraDTO;
import br.com.microservices.loja.dto.response.InfoFornecedorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {
    @RequestMapping("/info/{estado}")
    InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

    @RequestMapping("/pedido/{estado}")
    InfoPedidoDTO realizaPedido(List<ItensDaCompraDTO> itens);
}
