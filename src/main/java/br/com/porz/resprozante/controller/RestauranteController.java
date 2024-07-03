package br.com.porz.resprozante.controller;

import br.com.porz.resprozante.dto.PratoDto;
import br.com.porz.resprozante.dto.RestauranteDto;
import br.com.porz.resprozante.model.Prato;
import br.com.porz.resprozante.model.Restaurante;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

  Restaurante restaurante = new Restaurante();

  @PutMapping
  public Restaurante atualizaRestaurante(@RequestBody RestauranteDto restauranteDto) {
    restaurante.setNome(restauranteDto.nome());
    restaurante.setEndereco(restauranteDto.endereco());
    return restaurante;
  }


  @PostMapping("/prato")
  public Prato adicionarPrato(@RequestBody PratoDto pratoDto) {
     return restaurante.adicionar(new Prato(
        restaurante.getIdPrato(),
        pratoDto.nome(),
        pratoDto.valor(),
        pratoDto.tipoPrato()
    ));

  }




}
