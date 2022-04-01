package com.dio.exercicioComplexo.vendinha;

public abstract class Sucos {

    String tipo;
    double preco;

    public Sucos(String tipo, double preco) {
        this.tipo = tipo;
        this.preco = preco;
    }

    public abstract void calculaValor(double qtdLitros);
    protected abstract double aplicaDesconto(double valor, double qtdLitros);
    protected abstract void imprimiValor(double valorFinal, double qtdLitros);

    protected String getTipo() {
        return tipo;
    }

    protected void setTipo(String tipo) {
        this.tipo = tipo;
    }

    protected double getPreco() {
        return preco;
    }

    protected void setPreco(double preco) {
        this.preco = preco;
    }
}
