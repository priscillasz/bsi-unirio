package ed1priscilla.lista02;

// Questão 10

public class TesteEstoura {
    public static void main(String[] args) {
        Vetor_cod1_Priscilla vetor = new Vetor_cod1_Priscilla();

        for (int i = 0; i < 100001; i++) {
            Aluno aluno = new Aluno();
            vetor.adiciona(aluno);
        }
    }
}
