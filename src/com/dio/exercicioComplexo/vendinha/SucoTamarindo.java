package com.dio.exercicioComplexo.vendinha;

import java.text.DecimalFormat;

public class SucoTamarindo extends Sucos{

    DecimalFormat dc = new DecimalFormat("####0.00");

    public SucoTamarindo(String tipo, double preco) {
        super(tipo, preco);
    }


    @Override
    public void calculaValor(double qtdLitros) {
        double valorFinal = qtdLitros * this.getPreco();

        if(qtdLitros <= 2 || qtdLitros > 5){
            valorFinal -= aplicaDesconto(valorFinal, qtdLitros);
        }

        imprimiValor(valorFinal, qtdLitros);
    }

    @Override
    protected double aplicaDesconto(double valor, double qtdLitros) {
        double desconto;
        if(qtdLitros > 5)
            desconto = valor * (Math.floor(qtdLitros) * 0.06);
        else
            desconto = valor * (Math.floor(qtdLitros) * 0.04);

        return desconto;
    }

    @Override
    protected void imprimiValor(double valorFinal, double qtdLitros) {
        System.out.println("================================================");
        System.out.println("Suco de " + this.getTipo() + ", Litros: " + qtdLitros);
        System.out.println("Preço (com possíveis descontos aplicados): R$" + dc.format(valorFinal));
        System.out.println("================================================");

    }
}
