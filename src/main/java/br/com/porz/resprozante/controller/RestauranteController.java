package br.com.porz.resprozante.controller;

import br.com.porz.resprozante.dto.RestauranteDto;
import br.com.porz.resprozante.model.Restaurante;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

  Restaurante restaurante = new Restaurante();

  @PostMapping
  public Restaurante setRestaurante(@RequestBody RestauranteDto restauranteDto) {
    restaurante.setNome(restauranteDto.nome());
    restaurante.setEndereco(restauranteDto.endereco());
    return restaurante;
  }


}
