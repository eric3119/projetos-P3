package acoes;

import java.util.Scanner;

public class Login {

    public static void login(){

        Scanner input = new Scanner(System.in);

        System.out.println("Login");

        System.out.printf("Usuário: ");
        String user = input.nextLine();
        System.out.printf("\nSenha: ");
        String psw = input.nextLine();

        while(!(user.equals("admin") && psw.equals("admin"))){

            System.out.println("Login Incorreto");

            System.out.printf("Usuário: ");
            user = input.nextLine();
            System.out.printf("\nSenha: ");
            psw = input.nextLine();
        }
    }
}
