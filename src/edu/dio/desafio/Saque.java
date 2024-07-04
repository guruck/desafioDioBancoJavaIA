package edu.dio.desafio;

public class Saque extends Transacao {

  private double valorSaque;

  public Saque(double valorSaque) {
      this.valorSaque = valorSaque;
  }

  @Override
  public double getValor() {
      return valorSaque;
  }

  @Override
  public void registrar(Conta conta) {
      conta.sacar(valorSaque);
      System.out.println("Saque realizado com sucesso!");
      conta.adicionarTransacao(this);
  }
  @Override
  public String toString() {
    return "Saque   : [" + this.valorSaque + "]";
  }
}