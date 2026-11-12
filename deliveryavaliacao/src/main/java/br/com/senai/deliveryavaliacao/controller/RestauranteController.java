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
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.deliveryavaliacao.model.Restaurante;
import br.com.senai.deliveryavaliacao.service.RestauranteService;
import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/restaurante")
public class RestauranteController {

    private final RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @PostMapping 
    public ResponseEntity<Restaurante> cadastrarRestaurante(@Valid @RequestBody Restaurante restaurante) {

        //Optional<Restaurante> restauranteCadastrado = restauranteService.cadastrarRestaurante(restaurante);
        //if (restauranteCadastrado.isEmpty()){
         //    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       // }
       // return ResponseEntity.status(HttpStatus.CREATED)
                //.body(restauranteCadastrado.get());

                Restaurante novoRestaurante = restauranteService.cadastrarRestaurante(restaurante);
                return ResponseEntity.status(HttpStatus.CREATED).body(novoRestaurante);
       
    }

    @GetMapping
    public ResponseEntity<List<Restaurante>> ListarRestaurantes() {
        List<Restaurante> restaurantes = restauranteService.listarRestaurantes();
        return ResponseEntity.ok(restaurantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante>buscarRestaurantePorId(@PathVariable Integer id) {
        Optional<Restaurante> restaurante = restauranteService.buscarRestaurantePorId(id);
        if (restaurante.isPresent()) {
            return ResponseEntity.ok(restaurante.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Restaurante> atualizarSetor(@PathVariable Integer id, @Valid @RequestBody Restaurante restaurante) {
        Restaurante restauranteAtualizado = restauranteService.atualizarRestaurante(id, restaurante);
        return ResponseEntity.ok(restauranteAtualizado);
    }
    }

    