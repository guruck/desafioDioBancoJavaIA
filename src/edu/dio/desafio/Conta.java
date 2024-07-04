package edu.dio.desafio;

import java.time.LocalDateTime;
import java.util.Map;

public abstract class Conta {

  protected double saldo;
  private int numero;
  private Agencia agencia;
  private Cliente cliente;
  private Historico historico;
  private boolean status;

  public Conta(int numero, Agencia agencia, Cliente cliente) {
      this.numero = numero;
      this.agencia = agencia;
      this.cliente = cliente;
      this.historico = new Historico();
      this.status = true;
      this.cliente.adicionarConta(this);
  }

  public double getSaldo() {
      return saldo;
  }

  public int getNumero() {
      return numero;
  }

  public Agencia getAgencia() {
      return agencia;
  }

  public Cliente getCliente() {
      return cliente;
  }

  public Historico getHistorico() {
      return historico;
  }

  public boolean isAtiva() {
      return status;
  }

  public void ativarConta() {
      this.status = true;
  }

  public void desativarConta() {
      this.status = false;
  }

  public abstract void sacar(double valor) throws SaldoInsuficienteException;

  public abstract void depositar(double valor);

  public abstract void transferir(Conta contaDestino, double valor) throws SaldoInsuficienteException, TransacaoInvalidaException;

  public void adicionarTransacao(Transacao transacao) {
      this.historico.adicionarTransacao(transacao);
  }

  public void imprimirExtrato() {
    System.out.println("Extrato da Conta " + numero + ":");
    System.out.println("---------------------------------");
    System.out.println("Saldo atual: R$ " + String.format("%.2f", saldo));
    System.out.println("Histórico de transações:");
    for (Map.Entry<LocalDateTime, Transacao> entry : historico.getTransacoes().entrySet()) {
        LocalDateTime dataTransacao = entry.getKey();
        Transacao transacao = entry.getValue();
        System.out.println("Data: " + dataTransacao + ", Transacao: " + transacao);
    }
    System.out.println("---------------------------------");
  }

  @Override
  public String toString() {
    return "Numero=\'" + this.numero + "\', agencia=\'" + this.agencia.getNumero() + "\', cliente=" + this.cliente.getInfoCliente();
  }
}
