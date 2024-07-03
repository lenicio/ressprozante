package br.com.porz.resprozante.model;

import br.com.porz.resprozante.lista.TipoPrato;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Prato {
  private long id;
  private String nome;
  private double valor;
  private TipoPrato tipoPrato;
}
