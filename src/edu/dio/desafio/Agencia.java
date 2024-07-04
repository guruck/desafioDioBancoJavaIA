package edu.dio.desafio;

import java.util.ArrayList;
import java.util.List;

public class Agencia {

  private int numero;
  private String nome;
  private String cnpj;
  private String endereco;
  private List<Conta> contas;
  private List<Cliente> clientes;

  public Agencia(int numero, String nome, String cnpj, String endereco) {
    this.numero = numero;
    this.nome = nome;
    this.cnpj = cnpj;
    this.endereco = endereco;
    this.contas = new ArrayList<Conta>();
    this.clientes = new ArrayList<Cliente>();
  }

  public int getNumero(){
    return this.numero;
  }

  public void listarContas() {
    System.out.println("Contas da Agência " + nome + ":");
    for (Conta conta : contas) {
      System.out.println("- " + conta);
    }
  }

  public void adicionarConta(Conta conta) {
    this.contas.add(conta);
  }

  public void removerConta(Conta conta) {
    boolean desativada = false;
    for(Conta c : this.contas){
        if (c.equals(conta)){
            c.desativarConta();
            desativada = true;
        }
    };
    if (!desativada) {
      System.out.println("Conta não encontrada na agência.");
    }
  }

  public void listarClientes() {
    System.out.println("Clientes da Agência " + nome + ":");
    for (Cliente cliente : clientes) {
      System.out.println("- " + cliente);
    }
  }

  public void adicionarCliente(Cliente cliente) {
    this.clientes.add(cliente);
  }

  public void removerCliente(Cliente cliente) {
    boolean removido = false;
    for (Cliente c : this.clientes){
        if (c.equals(cliente)){
            clientes.remove(c);
            removido = true;
        }
    }
    if (!removido) {
      System.out.println("Cliente não encontrado na agência.");
    }
  }

  public void exibirExtrato(Conta conta) {
    conta.imprimirExtrato();
  }

  @Override
  public String toString() {
    return "Agencia{" +
        "numero=" + this.numero +
        ", nome='" + this.nome + '\'' +
        ", cnpj='" + this.cnpj + '\'' +
        ", endereco='" + this.endereco + '\'' +
        ", contas=" + this.contas +
        ", clientes=" + this.clientes +
        '}';
  }
}