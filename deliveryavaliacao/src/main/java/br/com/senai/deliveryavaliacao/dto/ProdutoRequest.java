package br.com.senai.deliveryavaliacao.dto;

import java.math.BigDecimal;

import br.com.senai.deliveryavaliacao.model.Restaurante;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ProdutoRequest {

    private String nome;

    @Column (precision = 10, scale = 2)
    private BigDecimal preco;

    @ManyToOne 
    @JoinColumn (name = "restaurante_id", nullable = false)
    Restaurante restaurante;

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

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

}
