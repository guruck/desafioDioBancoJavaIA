package edu.dio.desafio;

public class Transferencia extends Transacao {

    private Conta contaOrigem;
    private Conta contaDestino;
    private double valorTransferencia;

    public Transferencia(Conta contaOrigem, Conta contaDestino, double valorTransferencia) {
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valorTransferencia = valorTransferencia;
    }

    @Override
    public double getValor() {
        return valorTransferencia;
    }

    @Override
    public void registrar(Conta conta) {
        contaOrigem.transferir(contaDestino, valorTransferencia);
        System.out.println("Transferência realizada com sucesso!");
        conta.adicionarTransacao(this);
    }

    @Override
    public String toString() {
      return "TED /DOC: [" + this.valorTransferencia + "]";
    }
}