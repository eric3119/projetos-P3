package modelo;

import java.util.Scanner;

public class Erros {

    private static Scanner input = new Scanner(System.in);

    public static double entradaDouble() {
        while (true) {
            try {
                return Double.parseDouble(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro\n>>digite um numero decimal");
            }
        }
    }

    public static int entradaInt(int MIN, int MAX){
        while (true) {
            try {
                int valor = Integer.parseInt(input.nextLine());
                while(valor > MAX || valor < MIN){
                    System.out.println("Entrada incorreta");
                    valor = Integer.parseInt(input.nextLine());
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Erro\n>> digite um numero inteiro");
            }
        }
    }

    public static int entradaInt(){
        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro\n>> digite um numero inteiro");
            }
        }
    }
}
