package ed1priscilla.lista01;

public class Aluno {
    private int id;
    private String primeiroNome;
    private String ultimoNome;
    public Aluno(int id, String primeiroNome, String ultimoNome) {
        this.id = id;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
    }
    public int getId() { return id; }
}
