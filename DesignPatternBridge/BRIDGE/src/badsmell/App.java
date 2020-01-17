package badsmell;

public class App {
    public static void main(String[] args) {
        Formas forma1 = new CirculoAPI1();
        Formas forma2 = new CirculoAPI2();
        Formas forma3 = new QuadradoAPI1();
        Formas forma4 = new QuadradoAPI2();

        forma1.Desenhar();
        forma2.Desenhar();
        forma3.Desenhar();
        forma4.Desenhar();
    }
}
