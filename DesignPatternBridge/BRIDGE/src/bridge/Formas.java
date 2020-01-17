package bridge;

abstract class Formas {
    protected APIs APIdesenho;

    protected Formas(final APIs APIdesenho){
        this.APIdesenho = APIdesenho;
    }

    public abstract void desenhar();
}
