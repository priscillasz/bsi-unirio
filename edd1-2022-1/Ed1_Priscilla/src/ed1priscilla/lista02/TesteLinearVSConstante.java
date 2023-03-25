package ed1priscilla.lista02;

// Questão 4
public class TesteLinearVSConstante {
    public static void main(String[] args) {
        Vetor_cod1_Priscilla vetor = new Vetor_cod1_Priscilla();

        long inicio = System.currentTimeMillis();

        for (int i = 1; i < 100000; i++) {
            Aluno aluno = new Aluno();
            vetor.adiciona(aluno);
        }

        long fim = System.currentTimeMillis();

        double tempo = (fim - inicio) / 1000.0;

        System.out.println("Tempo em segundos = " + tempo);
    }
}
