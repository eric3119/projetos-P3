package bridge;

public class Circulo extends Formas{

    protected Circulo(APIs APIdesenho) {
        super(APIdesenho);
    }

    @Override
    public void desenhar() {
        APIdesenho.desenharFormas(10, 10);
    }
}
