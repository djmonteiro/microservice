package br.com.microservices.loja.service;

import br.com.microservices.loja.client.FornecedorClient;
import br.com.microservices.loja.dto.CompraDTO;
import br.com.microservices.loja.dto.InfoPedidoDTO;
import br.com.microservices.loja.dto.ItensDaCompraDTO;
import br.com.microservices.loja.dto.response.InfoFornecedorDTO;
import br.com.microservices.loja.model.Compra;
import com.netflix.discovery.DiscoveryClient;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
@Slf4j
@Service
public class CompraServiceImpl implements CompraService{

    private static final List<String> estados = Arrays.asList("AC","BA","SP","RJ");
    @Value("${app.fornecedor.uri}")
    private String uriApiFornecedor;

    @Autowired
    RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient eurekaClient;

    @Autowired
    private FornecedorClient fornecedorClient;

    @Override
    public Compra realizaCompra(CompraDTO compraDTO) {
        validaCompra(compraDTO);
        InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compraDTO.getEndereco().getEstado());
        System.out.println(info.getEndereco());
        InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compraDTO.getItens());
        //String pathFornecedor = uriApiFornecedor+"/info/"+compraDTO.getEndereco().getEstado();
//        ResponseEntity<InfoFornecedorDTO> exchange = restTemplate.exchange(pathFornecedor, HttpMethod.GET,null, InfoFornecedorDTO.class);
//        if (exchange.getStatusCode().equals(HttpStatus.OK)) {
//            log.info(exchange.getBody().toString());
//            System.out.println(exchange.getBody().getEndereco());
//        }
//        eurekaClient.getInstancesById("fornecedor").stream().forEach(instanceInfo -> {
//            System.out.println("localhost:"+instanceInfo.getPort());
//        });
        return null;
    }

    private void validaCompra(CompraDTO compraDTO){
        if(! estados.contains(compraDTO.getEndereco().getEstado()))
            throw new RuntimeException("Estado Não Existe");

       Stream<ItensDaCompraDTO> itensDaCompraDTOStream = compraDTO.getItens().stream().filter(itensDaCompraDTO -> {
            return itensDaCompraDTO.getQtd() <= 0;
       });

       if(itensDaCompraDTOStream.count() > 0)
           throw new RuntimeException("Não pode haver Itens com quantidade menor que zero");

    }
}
