package br.com.senai.deliveryavaliacao.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RestauranteRequest {

    @NotBlank (message = "Informe o nome do restaurante")
    @NotNull (message = "Informe o nome do restaurante")
    private String nome;

    @NotBlank (message = "Informe o endereço")
    @NotNull (message = "Informe o endereço")
    private String endereco;

    public RestauranteRequest() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}