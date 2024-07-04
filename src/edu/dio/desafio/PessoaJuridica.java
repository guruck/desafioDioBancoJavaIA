package edu.dio.desafio;

public class PessoaJuridica extends Cliente {

  private String nomeFantasia;
  private String razaoSocial;
  private String cnpj;

  public PessoaJuridica(String nomeFantasia, String razaoSocial, String cnpj, String endereco, String telefone) {
      super(endereco, telefone);
      this.nomeFantasia = nomeFantasia;
      this.razaoSocial = razaoSocial;
      this.cnpj = cnpj;
  }

  public String getNomeFantasia() {
      return nomeFantasia;
  }

  public String getRazaoSocial() {
      return razaoSocial;
  }

  public String getCnpj() {
      return cnpj;
  }

  @Override
  public String getTipoCliente() {
      return "Pessoa Jurídica";
  }
  @Override
  public String getInfoCliente() {
      return "cnpj=\'" + this.cnpj + "\'";
  }
}
