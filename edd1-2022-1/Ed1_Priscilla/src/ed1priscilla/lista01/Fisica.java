package ed1priscilla.lista01;

public class Fisica extends Disciplina {
    public Fisica(double prova1, double prova2, double trab1) {
        super(prova1, prova2, trab1);
    }
    public void calcularMedia() { media = (prova1 + prova2 + trab1) / 3; }
    public double getMedia() { return super.getMedia(); }
}
