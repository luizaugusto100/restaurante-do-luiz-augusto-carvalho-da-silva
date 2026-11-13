package br.com.senai.deliveryavaliacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.deliveryavaliacao.dto.ProdutoRequest;
import br.com.senai.deliveryavaliacao.model.Produto;
import br.com.senai.deliveryavaliacao.service.ProdutoService;
import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/produtos")
public class ProdutoController {

private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    
    @PostMapping
    public ResponseEntity<Produto> cadastrar(
            @Valid @RequestBody ProdutoRequest produto) {

        Optional<Produto> produtoCadastrado = produtoService.cadastrarProduto(produto);

        if (produtoCadastrado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoCadastrado.get());
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        return ResponseEntity.ok(
                produtoService.listarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(
            @PathVariable Integer id) {
            Optional<Produto> produto = produtoService.buscarProdutoPorId(id);
            if (produto.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

        return ResponseEntity.ok(produto.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Produto>> atualizarEquipamento(@PathVariable Integer id,
            @Valid @RequestBody ProdutoRequest produto) {

        Optional<Produto> produtoAtualizado = produtoService.atualizarProduto(id, produto);

        if (produtoAtualizado.isPresent()) {

            return ResponseEntity.ok(produtoAtualizado);
        }

        return ResponseEntity.notFound().build();

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class RestauranteNaoEncontradoException
            extends RuntimeException {

        public RestauranteNaoEncontradoException() {
            super("Restaurante não encontrado.");
        }

}
}
