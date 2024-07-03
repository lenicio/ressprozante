package br.com.porz.resprozante.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Restaurante {
  private long idPrato;
  private String nome;
  private String endereco;
  private List<Prato> pratos;

  public Restaurante() {
    this.idPrato = 0;
    pratos = new ArrayList<>();
  }


  public Restaurante(String nome, String endereco) {
    this.nome = nome;
    this.endereco = endereco;
    this.idPrato = 0;
    pratos = new ArrayList<>();
  }


  public Prato adicionar(Prato prato) {
    pratos.add(prato);
    this.idPrato++;
    return prato;
  }


  public void remover(Prato prato) {
    pratos.remove(prato);
  }

}
