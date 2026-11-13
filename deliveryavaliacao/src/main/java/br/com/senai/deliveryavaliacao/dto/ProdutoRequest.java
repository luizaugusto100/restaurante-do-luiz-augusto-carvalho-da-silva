package br.com.senai.deliveryavaliacao.dto;

import java.math.BigDecimal;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdutoRequest {

    @NotNull  (message = "Informe o nome do produto")
    @NotBlank (message = "Informe o nome do produto")
    private String nome;

    
    @Min (0)
    @NotNull (message = "Informe o preço")
    private BigDecimal preco;

    
    @NotNull (message = "O restaurante não pode ser nulo")
    Integer restauranteId;

    public ProdutoRequest() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(Integer restaurante) {
        this.restauranteId = restaurante;
    }

}
