package br.com.microservices.loja.controller;

import br.com.microservices.loja.dto.CompraDTO;
import br.com.microservices.loja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<?> realizaCompra(@RequestBody CompraDTO compraDTO){

        compraService.realizaCompra(compraDTO);

        return ResponseEntity.ok().build();

    }
}
