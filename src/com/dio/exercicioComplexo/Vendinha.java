package com.dio.exercicioComplexo;

import com.dio.exercicioComplexo.vendinha.SucoLimao;
import com.dio.exercicioComplexo.vendinha.SucoTamarindo;

import java.util.Scanner;

public final class Vendinha {

    boolean vendinhaAberta;
    double precoLimao, precoTamarindo;

    String tipoEscolhido;
    double qtdLitros;

    SucoLimao sucoLimao;
    SucoTamarindo sucoTamarindo;

    Scanner scan;

    public Vendinha(double precoLimao, double precoTamarindo, Scanner scan) {
        this.setVendinhaAberta(false);
        this.setPrecoLimao(precoLimao);
        this.setPrecoTamarindo(precoTamarindo);
        this.scan = scan;

        sucoLimao = new SucoLimao("Limão", precoLimao);
        sucoTamarindo = new SucoTamarindo("Tamarindo", precoTamarindo);
    }

    public void fazerVenda(){
        if (isVendinhaAberta()){
            System.out.println("================================================");
            System.out.println("Qual tipo de suco irá querer (Digite o caractere)? L - Limão | T - Tamarindo");
            this.tipoEscolhido = scan.next();

            verificaTipo(this.tipoEscolhido);
        } else{
            System.out.println("A vendinha de sucos está fechada. Abra-a para realizar vendas.");
        }
    }

    public void fecharVendinha(){
        System.out.println("================================================");
        System.out.println("Vendinha de sucos fechada!");
        this.setVendinhaAberta(false);
    }

    public void abrirVendinha(){
        System.out.println("================================================");
        System.out.println("Vendinha de sucos aberta!");
        this.setVendinhaAberta(true);
    }

    public void imprimirPrecos(){
        System.out.println("Venda de sucos");
        System.out.println("Suco de Limão: R$" +  getPrecoLimao() + " L | Desconto de 3% por litro(Até 2L)");
        System.out.println(
                "Suco de Tamarindo: R$" +  getPrecoTamarindo() + " L | Desconto de 4% por litro(Até 2L) ou desconto de 6% (acima de 5L) "
        );

    }

    private void verificaTipo(String tipo) {
        switch (tipo){
            case "L":
            case "l":
                System.out.println("Digite a quantidade em litros:");
                qtdLitros = scan.nextDouble();
                sucoLimao.calculaValor(qtdLitros);
                break;
            case "T":
            case "t":
                System.out.println("Digite a quantidade em litros:");
                qtdLitros = scan.nextDouble();
                sucoTamarindo.calculaValor(qtdLitros);
                break;
            default:
                System.out.println("Caractere inválido.");
                break;
        }
    }

    public boolean isVendinhaAberta() {
        return vendinhaAberta;
    }

    public void setVendinhaAberta(boolean vendinhaAberta) {
        this.vendinhaAberta = vendinhaAberta;
    }

    public double getPrecoLimao() {
        return precoLimao;
    }

    public void setPrecoLimao(double precoLimao) {
        this.precoLimao = precoLimao;
    }

    public double getPrecoTamarindo() {
        return precoTamarindo;
    }

    public void setPrecoTamarindo(double precoTamarindo) {
        this.precoTamarindo = precoTamarindo;
    }
}
