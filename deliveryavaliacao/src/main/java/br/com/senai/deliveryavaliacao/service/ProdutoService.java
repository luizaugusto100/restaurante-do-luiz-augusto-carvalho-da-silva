package br.com.senai.deliveryavaliacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.senai.deliveryavaliacao.dto.ProdutoRequest;
import br.com.senai.deliveryavaliacao.model.Produto;
import br.com.senai.deliveryavaliacao.model.Restaurante;
import br.com.senai.deliveryavaliacao.repository.ProdutoRepository;
import br.com.senai.deliveryavaliacao.repository.RestauranteRepository;

@Service 
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    private final RestauranteRepository restauranteRepository;

    public ProdutoService (ProdutoRepository produtoRepository, RestauranteRepository restauranteRepository){
        this.produtoRepository = produtoRepository;
        this.restauranteRepository = restauranteRepository;
        
    }

    public Optional<Produto> cadastrarProduto( ProdutoRequest produto) {

        Optional<Restaurante> restauranteEncontrado =
            restauranteRepository.findById(produto.getRestauranteId());

    if (restauranteEncontrado.isEmpty()) {
        return Optional.empty();
    }
    Produto produto2 = new Produto();
    produto2.setRestauranteId(restauranteEncontrado.get());
    produto2.setNome(produto.getNome());
    produto2.setPreco(produto.getPreco());

    return Optional.of(produtoRepository.save(produto2));
    }

     public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarProdutoPorId(Integer id) {
        return produtoRepository.findById(id);
    }

    public Optional<Produto> atualizarProduto(Integer id, ProdutoRequest novoproduto) {
        
        Optional<Produto> ProdutoEncontrado = produtoRepository.findById(id);
        
        if (!ProdutoEncontrado.isPresent()) {
            return Optional.empty();
        }

        Optional<Restaurante> restauranteEncontrado = restauranteRepository.findById(novoproduto.getRestauranteId());
        if (restauranteEncontrado.isEmpty()) {
            return Optional.empty();
        }
            
        

        Produto produto2 = ProdutoEncontrado.get();

        produto2.setNome(novoproduto.getNome());
        produto2.setPreco(novoproduto.getPreco());
        produto2.setRestauranteId(restauranteEncontrado.get());
            
        return Optional.of(produtoRepository.save(produto2));
    }

    }

    

