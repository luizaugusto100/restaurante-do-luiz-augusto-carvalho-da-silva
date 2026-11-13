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

        Restaurante restaurante2 = restauranteEncontrado.get();
        restaurante2.setNome(novosDados.getNome());
        restaurante2.setEndereco(novosDados.getEndereco());

        return restauranteRepository.save(restaurante2);
    }

}