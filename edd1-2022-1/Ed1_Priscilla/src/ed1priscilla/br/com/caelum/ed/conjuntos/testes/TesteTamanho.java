package ed1priscilla.br.com.caelum.ed.conjuntos.testes;

import ed1priscilla.br.com.caelum.ed.conjuntos.ConjuntoEspalhamento;

public class TesteTamanho {
    public static void main(String[] args) {

        /* novo conjunto */
        ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();

        /* verifica o tamanho do conjunto */
        System.out.println("O tamanho do conjunto é 0? " + (conjunto.tamanho() == 0));

        /* adiciona palavras ao conjunto */
        conjunto.adiciona("Priscilla");
        conjunto.adiciona("Louise");
        conjunto.adiciona("Letícia");

        /* verifica novamente o tamanho do conjunto */
        System.out.println("O tamanho do conjunto é 1? " + (conjunto.tamanho() == 1));
    }
}
