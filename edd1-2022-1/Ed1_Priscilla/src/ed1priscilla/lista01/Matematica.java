package ed1priscilla.lista01;

public class Matematica extends Disciplina {
    public Matematica(double prova1, double prova2, double trab1) {
        super(prova1, prova2, trab1);
    }
    public void calcularMedia() { media = (trab1 * 2 + prova1 * 4 + prova2 * 4) / (2 + 8); }
    public double getMedia() {
        return super.getMedia();
    }
}
