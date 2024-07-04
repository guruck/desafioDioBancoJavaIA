package edu.dio.desafio;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {

  private String endereco;
  private List<Conta> contas;
  private String telefone;

  public Cliente(String endereco, String telefone) {
      this.endereco = endereco;
      this.telefone = telefone;
      this.contas = new ArrayList<Conta>();
  }

  public void realizarTransacao(Conta conta, Transacao transacao) {
      if (conta.getCliente().equals(this)) {
          transacao.registrar(conta);
          System.out.println("Transação realizada com sucesso!");
      } else {
          System.out.println("Conta não pertence a este cliente.");
      }
  }

  public void adicionarConta(Conta conta) {
      this.contas.add(conta);
  }

  public void removerConta(Conta conta) {
    boolean desativada = false;
    for(Conta c : this.contas){
        if (c.equals(conta)){
            this.contas.remove(c);
            desativada = true;
        }
    };
    if (!desativada) {
      System.out.println("Conta não encontrada na agência.");
    }
  }

  public abstract String getTipoCliente();
  public abstract String getInfoCliente();

  public String getEndereco() {
      return endereco;
  }

  public List<Conta> getContas() {
      return contas;
  }

  public String getTelefone() {
      return telefone;
  }
}
