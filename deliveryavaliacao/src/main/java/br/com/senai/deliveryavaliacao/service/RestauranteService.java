package br.com.senai.deliveryavaliacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.senai.deliveryavaliacao.model.Restaurante;
import br.com.senai.deliveryavaliacao.repository.RestauranteRepository;

@Service 

public class RestauranteService {

    private final RestauranteRepository restauranteRepository;

    private RestauranteService(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public Restaurante cadastrarRestaurante(Restaurante restaurante) {

        //Restaurante restaurante2 = new Restaurante();
        //restaurante2.setNome(restaurante.getNome());
       // restaurante2.setEndereco(restaurante.getEndereco());

       // return Optional.of(restauranteRepository.save(restaurante2));

       return restauranteRepository.save(restaurante);
    }

    public List<Restaurante> listarRestaurantes() {
        return restauranteRepository.findAll();
    }

    public Optional<Restaurante> buscarRestaurantePorId(Integer id) {
        return restauranteRepository.findById(id);
    }

    public Restaurante atualizarRestaurante(Integer id, Restaurante novosDados) {
        Optional<Restaurante> restauranteEncontrado = restauranteRepository.findById(id);
        
        if (!restauranteEncontrado.isPresent()) {
            return null;
        }

        Restaurante restaurante = restauranteEncontrado.get();
        restaurante.setNome(novosDados.getNome());
        restaurante.setEndereco(novosDados.getEndereco());

        return restauranteRepository.save(restaurante);
    }

     public void excluirRestaurante(Integer id) {
        restauranteRepository.deleteById(id);
    }

}