package modelo;

public abstract class RecFisicos {
    private boolean disp;

    public RecFisicos(boolean disp) {
        this.disp = disp;
    }

    @Override
    public String toString() {
        return (disp)? "\nDisponível":"\nNão disponível";
    }
}
