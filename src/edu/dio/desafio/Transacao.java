package edu.dio.desafio;

public abstract class Transacao {

    public abstract double getValor();

    public abstract void registrar(Conta conta);
}
