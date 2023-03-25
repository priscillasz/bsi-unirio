package ed1priscilla.lista02;

// Questão 2

public class TesteAdicionaPorPosicao {
    public static void main(String args[]) {
        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        Aluno a3 = new Aluno();

        a1.setNome("Rafael");
        a2.setNome("Paulo");
        a3.setNome("Ana");

        Vetor_cod1_Priscilla lista = new Vetor_cod1_Priscilla();

        lista.adiciona(a1);
        lista.adiciona(0, a2);
        lista.adiciona(1, a3);

        System.out.println(lista);
    }
}
