package ed1priscilla.lista02;

// Questão 2

public class TestePegaPorPosicao {
    public static void main(String[] args) {
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();

        a1.setNome("Rafael");
        a2.setNome("Paulo");

        Vetor_cod1_Priscilla lista = new Vetor_cod1_Priscilla();

        lista.adiciona(a1);
        lista.adiciona(a2);

        Aluno aluno1 = lista.pega(0);
        Aluno aluno2 = lista.pega(1);

        System.out.println(aluno1);
        System.out.println(aluno2);
    }
}
