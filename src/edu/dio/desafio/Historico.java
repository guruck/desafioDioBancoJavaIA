package edu.dio.desafio;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Historico {
  private Map<LocalDateTime, Transacao> transacoes;

  public Historico() {
      this.transacoes = new HashMap<LocalDateTime, Transacao>();
  }

  public void adicionarTransacao(Transacao transacao) {
      this.transacoes.put(LocalDateTime.now(), transacao);
  }

  public Map<LocalDateTime, Transacao> getTransacoes() {
      return transacoes;
  }
}
