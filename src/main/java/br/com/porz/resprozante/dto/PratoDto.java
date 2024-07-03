package br.com.porz.resprozante.dto;

import br.com.porz.resprozante.lista.TipoPrato;

public record PratoDto(String nome, double valor, TipoPrato tipoPrato) {
}
