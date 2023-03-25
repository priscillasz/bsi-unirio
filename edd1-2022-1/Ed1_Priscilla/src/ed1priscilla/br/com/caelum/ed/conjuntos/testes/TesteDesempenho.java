package ed1priscilla.br.com.caelum.ed.conjuntos.testes;

import ed1priscilla.br.com.caelum.ed.conjuntos.ConjuntoEspalhamento;

public class TesteDesempenho {
    public static void main(String[] args) {

        /* pega o tempo de inicio */
        long inicio = System.currentTimeMillis();

        /* novo conjunto */
        ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();

        /* adiciona palavras ao conjunto até que o index seja menor que 5000*/
        for (int index = 0; index < 50000; index++) {
            conjunto.adiciona("palavra" + index);
        }

        /* verifica se o conjunto contem cada uma das palavras adicionas anteriormente */
        for (int index = 0; index < 50000; index++) {
            conjunto.contem("palavra" + index);
        }

        /* pega o tempo de finalização */
        long fim = System.currentTimeMillis();

        /* calcula o tempo de desempenho */
        System.out.println("Tempo: " + (fim - inicio) / 1000.00 + "ms");
    }
}