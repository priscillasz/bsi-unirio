package ed1priscilla.br.com.caelum.ed.conjuntos.testes.generico;

import ed1priscilla.br.com.caelum.ed.conjuntos.generico.ConjuntoEspalhamentoGenerico;

public class TesteConjuntoGenerico {
    public static void main(String[] args) {
        /* cria um novo conjunto */
        ConjuntoEspalhamentoGenerico conjunto = new ConjuntoEspalhamentoGenerico();

        /* adiciona palavras ao conjunto */
        conjunto.adiciona("Garrafa");
        conjunto.adiciona("Livro");
        conjunto.adiciona("Celular");
        conjunto.adiciona("Relógio");

        /* retorna todas as palavras do conjunto */
        System.out.println(conjunto.pegaTodas());
    }
}
