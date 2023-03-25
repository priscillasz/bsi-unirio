package ed1priscilla.br.com.caelum.ed.conjuntos.testes;

import ed1priscilla.br.com.caelum.ed.conjuntos.ConjuntoEspalhamento;

public class TesteEspalhamento {
    public static void main(String[] args) {
        /* novo conjunto */
        ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();

        /* adiciona palavras no conjunto até que tenham 5 no conjunto */
        for (int index = 0; index < 5; index++) {
            conjunto.adiciona("" + index);
        }

        /* imprime a tabela */
        conjunto.imprimeTabela();
    }
}

