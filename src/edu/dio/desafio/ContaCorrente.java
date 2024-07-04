package edu.dio.desafio;

public class ContaCorrente extends Conta {

  private double limite;
  private double limiteSaques;

  public ContaCorrente(int numero, Agencia agencia, Cliente cliente, double limite, double limiteSaques) {
    super(numero, agencia, cliente);
    this.limite = limite;
    this.limiteSaques = limiteSaques;
  }

  public double getLimite() {
    return this.limite;
  }

  public void setLimite(double limite) {
    this.limite = limite;
  }

  public double getLimiteSaques() {
    return this.limiteSaques;
  }

  public void setLimiteSaques(double limiteSaques) {
    this.limiteSaques = limiteSaques;
  }

  @Override
  public void sacar(double valor) throws SaldoInsuficienteException {
    if (valor <= 0) {
      throw new TransacaoInvalidaException("Valor do deposito invalido.");
    }
    if (valor > (this.saldo + limite)) {
      throw new SaldoInsuficienteException("Saldo insuficiente para saque.");
    }

    if (valor > limiteSaques) {
      System.out.println("Valor do saque excede o limite diário. Saque realizado no limite disponível.");
      valor = limiteSaques;
    }

    this.saldo -= valor;

  }

  @Override
  public void depositar(double valor) throws TransacaoInvalidaException {
    if (valor <= 0) {
      throw new TransacaoInvalidaException("Valor do deposito invalido.");
    }
    this.saldo += valor;

  }

  @Override
  public void transferir(Conta contaDestino, double valor) throws SaldoInsuficienteException, TransacaoInvalidaException {
      if (valor <= 0) {
          throw new TransacaoInvalidaException("Valor da transferência deve ser maior que zero.");
      }

      if (valor > (this.saldo + limite)) {
          throw new SaldoInsuficienteException("Saldo insuficiente para transferência.");
      }

      this.saldo -= valor;
      contaDestino.saldo += valor;
  }
}