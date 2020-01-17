package modelo;

public class Onibus extends RecFisicos{
    private String id;


    public Onibus(boolean disp, String id) {
        super(disp);
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString()+String.format("\nID: %s", id);
    }
}
