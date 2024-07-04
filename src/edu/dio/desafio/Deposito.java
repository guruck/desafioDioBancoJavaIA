package edu.dio.desafio;

public class Deposito extends Transacao {

  private double valorDeposito;

  public Deposito(double valorDeposito) {
      this.valorDeposito = valorDeposito;
  }

  @Override
  public double getValor() {
      return this.valorDeposito;
  }

  @Override
  public void registrar(Conta conta) {
      conta.depositar(valorDeposito);
      System.out.println("Depósito realizado com sucesso!");
      conta.adicionarTransacao(this);
  }

  @Override
  public String toString() {
    return "Deposito: [" + this.valorDeposito + "]";
  }
}