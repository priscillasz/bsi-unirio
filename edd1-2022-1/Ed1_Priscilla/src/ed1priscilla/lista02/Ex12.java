package ed1priscilla.lista02;

import java.util.ArrayList;
import java.util.Vector;

// Questão 12

public class Ex12 {
    public static void main(String[] args) {
        Vetor_cod1_Priscilla lista = new Vetor_cod1_Priscilla();

        // tamanho antes
        System.out.println(lista.tamanho());

        // adicionar 1000 alunos
        for (int i = 0; i < 100; i++) {
            lista.adiciona(new Aluno("Aluno "+ i));
        }

        // tamanho depois
        System.out.println(lista.tamanho());

        // vetor da classe Vector
        Vector<Aluno> vetor = new Vector<>();

        // tamanho do vetor antes
        System.out.println(vetor.size());

        // transferir os alunos do vetor pra esse novo
        for (int i = 0; i < 100; i++) {
            vetor.add(i, lista.pega(i));
        }

        // tamanho do vetor depois
        System.out.println(vetor.size());

        // vetor da classe ArrayList
        ArrayList<Aluno> arrayList = new ArrayList<>();

        // tamanho da arraylist antes
        System.out.println(arrayList.size());

        // passar os alunos do vector pra arraylist
        for (int i = 0; i < vetor.size(); i++) {
            arrayList.add(vetor.get(i));
        }

        // tamanho da arraylist depois
        System.out.println(arrayList.size());
    }
}
