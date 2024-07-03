package br.com.porz.resprozante.controller;

import br.com.porz.resprozante.dto.PratoDto;
import br.com.porz.resprozante.dto.RestauranteDto;
import br.com.porz.resprozante.model.Prato;
import br.com.porz.resprozante.model.Restaurante;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


  @GetMapping("/pratos")
  public List<Prato> listaPratos() {
    return restaurante.getPratos();
  }


  @GetMapping("/prato")
  public ResponseEntity<Prato> buscarPrato(@RequestParam long id) {
    for (Prato prato : restaurante.getPratos()) {
      if (prato.getId() == id) {
        return ResponseEntity.ok(prato);
      }
    }
    return ResponseEntity.notFound().build();
  }


  @PutMapping("/prato")
  public ResponseEntity<Object> editaPrato(@RequestParam long id, @RequestBody PratoDto pratoDto) {
    for (Prato prato : restaurante.getPratos()) {
      if (prato.getId() == id) {
        prato.setNome(pratoDto.nome());
        prato.setValor(pratoDto.valor());
        prato.setTipoPrato(pratoDto.tipoPrato());
        return ResponseEntity.ok(prato);
      }
    }

    Map<String, String> resposta = new HashMap<>();
    resposta.put("mensagem", "prato não encontrado!");

    return ResponseEntity.status(404).body(resposta);
  }


  @DeleteMapping("/prato")
  public ResponseEntity<Object> deletaPrato(@RequestParam long id) {

    Map<String, String> respota = new HashMap<>();

    for (Prato prato : restaurante.getPratos()) {
      if (prato.getId() == id) {
        restaurante.remover(prato);
        respota.put("mensagem", "prato removido com sucesso!");
        return ResponseEntity.ok(respota);
      }
    }

    respota.put("mensagem", "prato não encontrado!");
    return ResponseEntity.status(404).body(respota);
  }


}
