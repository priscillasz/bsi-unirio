package ed1priscilla.br.com.caelum.ed.listasligadas;

import java.util.ArrayList;
import java.util.LinkedList;
public class TestePerformance {

    public static void main(String[] args) {
        ArrayList<String> vetor = new ArrayList<String>(); // Lista com alocação dinamica
        LinkedList<String> lista = new LinkedList<String>(); // Lista duplamente encadeada

        int numeroDeElementos = 40000;

        /* Inserção -------------------------------*/

        long inicioVetor = System.currentTimeMillis();
        for(int i = 0; i < numeroDeElementos; i++) {
            vetor.add(0, "elemento " + i);
        }
        long fimVetor = System.currentTimeMillis();
        System.out.println("Tempo decorrido do preenchimento do vetor: " + (fimVetor - inicioVetor) + " milli");

        long inicioLista = System.currentTimeMillis();
        for(int i = 0; i < numeroDeElementos; i++) {
            lista.add(0, "elemento " + i);
        }
        long fimLista = System.currentTimeMillis();
        System.out.println("Tempo decorrido do preenchimento da lista: " + (fimLista - inicioLista) + " milli");


        /* Percorrendo ------------------------------*/

        inicioVetor = System.currentTimeMillis();
        for(int i = 0; i < numeroDeElementos; i++) {
            vetor.get(i);
        }
        fimVetor = System.currentTimeMillis();
        System.out.println("Tempo decorrido percorrendo o vetor: " + (fimVetor - inicioVetor) + " milli");


        inicioLista = System.currentTimeMillis();
        for(int i = 0; i < numeroDeElementos; i++) {
            lista.get(i);
        }
        fimLista = System.currentTimeMillis();
        System.out.println("Tempo decorrido percorrendo a lista: " + (fimLista - inicioLista) + " milli");

        /* Removendo -------------------------------------*/

        inicioVetor = System.currentTimeMillis();
        for(int i = 0; i < numeroDeElementos; i++) {
            vetor.remove(0);
        }
        fimVetor = System.currentTimeMillis();
        System.out.println("Tempo decorrido removendo do vetor: " + (fimVetor - inicioVetor) + " milli");

        inicioLista = System.currentTimeMillis();
        for(int i = 0; i < numeroDeElementos; i++) {
            lista.remove(0);
        }
        fimLista = System.currentTimeMillis();
        System.out.println("Tempo decorrido removendo da lista: " + (fimLista - inicioLista) + " milli");

        /* CONCLUSÃO
         *					ArrayList	LinkedList
         * Inserção						Mais rápido
         * Percorrimento	Mais rápido
         * Remoção						Mais rápido
         *
         * O ArrayList é mais lento nas inserção e remoções, poi para esta operação é necessario percorrer
         * todo o array interno para inserir ou remover um elemento. Já no LinkedList vamos direto ao elento
         *
         * O ArrayList é mais rápido para percorrer os elemento sequencialmente pois para tal apenas precisamos
         * incrementar o indice do array. No LinkedList presisamos verificar qual é o proximo elemento a partir
         * do inicio da lista em diante
         * */
    }
}

