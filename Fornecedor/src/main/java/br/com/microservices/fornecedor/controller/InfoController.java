package br.com.microservices.fornecedor.controller;

import br.com.microservices.fornecedor.dto.response.InfoFornecedorDTO;
import br.com.microservices.fornecedor.service.InfoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/info")
public class InfoController {
    @Autowired
    private InfoService infoService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<InfoFornecedorDTO>> getInfoFornecedores(){
        List<InfoFornecedorDTO> listFornecedoresDTO = infoService.getInfoTodos().stream().map(infoFornecedor -> {
            return modelMapper.map(infoFornecedor,InfoFornecedorDTO.class);
        }).collect(Collectors.toList());
        return new ResponseEntity(listFornecedoresDTO, HttpStatus.FOUND);
    }

    @GetMapping("/{estado}")
    public ResponseEntity<InfoFornecedorDTO> getInfoFornecedor(@PathVariable String estado){
        InfoFornecedorDTO infoFornecedorDTO = modelMapper.map(infoService.getInfoPorEstado(estado),InfoFornecedorDTO.class);
        return new ResponseEntity(infoFornecedorDTO, HttpStatus.OK);
    }

}
