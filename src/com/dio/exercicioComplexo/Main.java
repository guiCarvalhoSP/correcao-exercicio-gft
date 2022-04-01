package com.dio.exercicioComplexo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean verificador = false;
        double precoLimao = 2.0d, precoTamarindo = 3.0d;

        Scanner scanner = new Scanner(System.in);
        Vendinha vendinha = new Vendinha(precoLimao, precoTamarindo, scanner);

        do {
            if(!vendinha.isVendinhaAberta()){
                vendinha.abrirVendinha();
                verificador = vendinha.isVendinhaAberta();
            }

            vendinha.imprimirPrecos();

            System.out.println("Deseja fazer uma nova venda? S - SIM, N - NÃO (Fechar a loja):");
            String fecharLoja = scanner.next();

            if (!fecharLoja.equals("S")){
                vendinha.fecharVendinha();
                verificador = vendinha.isVendinhaAberta();
            } else{
                vendinha.fazerVenda();
            }

        } while(verificador);
    }
}
