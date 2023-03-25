package ed1priscilla.lista01;

public class Ex02 {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno(12345, "Priscilla", "Souza");
        Aluno aluno2 = new Aluno(12346, "Jonathan", "Souza");
        Lista lista = new Lista();
        lista.insere(aluno1);
        if (!lista.busca(aluno2)) {
            lista.insere(aluno2);
            System.out.println("Aluno inserido.");
        } else {
            System.out.println("Id já existe no sistema.");
        }
    }
}
