package ed1priscilla.br.com.caelum.ed.conjuntos.testes;

import ed1priscilla.br.com.caelum.ed.conjuntos.ConjuntoEspalhamento;

public class TesteAdiciona {
    public static void main(String[] args) {

        /* cria um novo conjunto */
        ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();

        /* adiciona novas palavras no conjunto */
        conjunto.adiciona("palavra");
        conjunto.adiciona("computador");
        conjunto.adiciona("apostila");

        /* verifica o tamanho do conjunto */
        System.out.println("O tamanho do conjunto é 3? " + (conjunto.tamanho() == 3));
    }
}
