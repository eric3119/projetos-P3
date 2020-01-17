import acoes.Login;
import opcoes.*;

public class Isoccer {

    public static void main(String[] args) {

        Login.login();

        boolean nSair = true;
        while(nSair) {
            nSair = new FacadeMenu().principal();
        }
    }
}
