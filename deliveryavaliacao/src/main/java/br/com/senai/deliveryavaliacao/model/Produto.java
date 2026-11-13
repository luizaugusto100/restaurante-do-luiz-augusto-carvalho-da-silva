package br.com.senai.deliveryavaliacao.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity 
@Table (name = "produtos")
public class Produto {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull  (message = "Informe o nome do produto")
    @NotBlank (message = "Informe o nome do produto")
    private String nome;

    
    @Min (0)
    @NotNull (message = "Informe o preço")
    private BigDecimal preco;

    @ManyToOne 
    @JoinColumn (name = "restaurante_id", nullable = false)
    private Restaurante restauranteId;

    public Produto() {

    }

    public Integer getId() {
        return id;
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

    public Restaurante getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(Restaurante restaurante) {
        this.restauranteId = restaurante;
    }

}