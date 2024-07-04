package edu.dio.desafio;

public class TransacaoInvalidaException extends RuntimeException {

  public TransacaoInvalidaException(String message) {
      super(message);
  }
}
