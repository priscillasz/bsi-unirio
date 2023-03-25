package ed1priscilla.lista02;

// Questão 7
public class Teste {
    public static void main(String[] args) {
        Aluno a1 = new Aluno();
        a1.setNome("Rafael");

        Vetor_cod1_Priscilla lista = new Vetor_cod1_Priscilla();

        lista.adiciona(a1);

        lista.pega(0);
        lista.pega(1);
        lista.pega(100000000);
    }
}
