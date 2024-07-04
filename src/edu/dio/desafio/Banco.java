package edu.dio.desafio;

import java.util.ArrayList;
import java.util.List;

public class Banco {

  private int numero;
  private String nome;
  private List<Agencia> agencias;

  public Banco(int numero, String nome) {
    this.numero = numero;
    this.nome = nome;
    this.agencias = new ArrayList<Agencia>();
  }

  public void listarAgencias() {
    System.out.println("Agências do Banco " + nome + ":");
    for (Agencia agencia : agencias) {
      System.out.println("- " + agencia);
    }
  }

  public void adicionarAgencia(Agencia agencia) {

    if (agencias.stream().anyMatch(a -> a.getNumero() == agencia.getNumero())){
      System.out.println("Numero de agencia ja existente" + agencias.stream().filter(a -> a.getNumero() == agencia.getNumero()).toString());
    }else{
      this.agencias.add(agencia);
      System.out.println("Agencia adicionada: " + agencia);
    }
  }

  @Override
  public String toString() {
    return "Banco[" + this.numero + "] " + this.nome + " Agencias: " + this.agencias;
  }

  public Agencia getAgencia(int numeroAgencia){
    List<Agencia> finded = this.agencias.stream().filter(a -> a.getNumero() == numeroAgencia).toList();
    if (finded.size() > 0){
      return finded.get(0);
    }
    return null;
  }
}
