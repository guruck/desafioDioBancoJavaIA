package edu.dio.desafio;

public class ContaPoupanca extends Conta {

  public ContaPoupanca(int numero, Agencia agencia, Cliente cliente) {
      super(numero, agencia, cliente);
  }

  @Override
  public void sacar(double valor) throws SaldoInsuficienteException, TransacaoInvalidaException {
      if (valor <= 0) {
        throw new TransacaoInvalidaException("Valor do saque invalido.");
      }
      if (valor > this.saldo) {
          throw new SaldoInsuficienteException("Saldo insuficiente para saque.");
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

      if (valor > this.saldo) {
          throw new SaldoInsuficienteException("Saldo insuficiente para transferência.");
      }

      this.saldo -= valor;
      contaDestino.saldo += valor;
  }
}
