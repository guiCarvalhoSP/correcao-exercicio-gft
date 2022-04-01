package com.dio.exercicioSimplificado;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ExercicioVersaoSimples {
    public static void main(String[] args) {
        double qtdLitros, precoLimao = 2.0d, precoTamarindo = 3.0d, valorPago = 0;
        double desconto;
        boolean vendaAberta = true;
        String saborEscolhido;
        
        Scanner scan = new Scanner(System.in);
        DecimalFormat dc = new DecimalFormat("####0.00");

        System.out.println("Vendinha de sucos. Preço do sucos:");
        System.out.println("Limão R$" + precoLimao + " (por litro) | Até 2L desconto de 3% por litro");
        System.out.println("Tamarindo R$" + precoTamarindo + " (por litro) | Até 2L desconto de 4% por litro; acima de 5L desconto de 6% por litro");

        do {

            String fazerVenda;
            System.out.println("Digite o sabor escolhido: L - Limão; T - Tamarindo: ");
            saborEscolhido = scan.next();

            switch (saborEscolhido){
                case "L":
                    System.out.println("Sabor escolhido: Limão");
                    System.out.println("Digite a quantidade em litros desejada: ");
                    qtdLitros = scan.nextFloat();
                    
                    valorPago = precoLimao * qtdLitros;
                    if (qtdLitros >= 1 && qtdLitros <= 2) {
                        desconto = 0.03f * Math.floor(qtdLitros);
                        valorPago -= valorPago * desconto;
                    }
                    break;

                case "T":
                    System.out.println("Sabor escolhido: Tamarindo");
                    System.out.println("Digite a quantidade em litros desejada: ");
                    qtdLitros = scan.nextFloat();

                    valorPago = precoTamarindo * qtdLitros;
                    if (qtdLitros >= 1 && qtdLitros <= 2) {
                        desconto = 0.04f * Math.floor(qtdLitros);
                        valorPago -= valorPago * desconto;
                    }

                    if (qtdLitros > 5){
                        desconto = 0.06f * Math.floor(qtdLitros);
                        valorPago -= valorPago * desconto;
                    }
                    break;

                default:
                    System.out.println("Valor inválido. tente novamente");
                    valorPago = 0;
                    break;
            }

            System.out.println("Valor total a pagar: R$" + dc.format(valorPago));
            System.out.println("Deseja fazer nova venda? S - SIM, N - NÃO (Encerra o programa).");
            fazerVenda = scan.next();

            if(!fazerVenda.equals("S"))
                vendaAberta = false;
            
        } while(vendaAberta);
    }
}
