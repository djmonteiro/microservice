package br.com.microservices.loja.model;


import java.util.List;

public class Compra {
    private int id;
    private List<ItemDaCompra> itens;
    private String enderecoRua;
    private int enderecoNumero;
    private String enderecoEstado;
}
