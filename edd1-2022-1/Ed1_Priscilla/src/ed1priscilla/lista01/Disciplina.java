package ed1priscilla.lista01;

public class Disciplina {
    protected double prova1;
    protected double prova2;
    protected double trab1;
    protected double media;
    public Disciplina(double prova1, double prova2, double trab1) {
        this.prova1 = prova1;
        this.prova2 = prova2;
        this.trab1 = trab1;
    }
    public void calcularMedia() { }
    public double getMedia() { return media; }
}
