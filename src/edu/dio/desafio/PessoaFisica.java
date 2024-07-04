package edu.dio.desafio;

import java.time.LocalDate;

public class PessoaFisica extends Cliente {

  private String nome;
  private String cpf;
  private String email;
  private LocalDate dataNascimento;

  public PessoaFisica(String nome, String cpf, String email, LocalDate dataNascimento, String endereco, String telefone) {
      super(endereco, telefone);
      this.nome = nome;
      this.cpf = cpf;
      this.email = email;
      this.dataNascimento = dataNascimento;
  }

  public String getNome() {
      return nome;
  }

  public String getCpf() {
      return cpf;
  }

  public String getEmail() {
      return email;
  }

  public LocalDate getDataNascimento() {
      return dataNascimento;
  }

  @Override
  public String getTipoCliente() {
      return "Pessoa Física";
  }
  @Override
  public String getInfoCliente() {
      return "cpf=\'" + this.cpf + "\'";
  }

  @Override
  public String toString() {
    return "Nome=\'" + this.nome + "\', cpf=\'" + this.cpf + "\', contas=" + this.getContas();
  }
}
