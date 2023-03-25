package ed1priscilla.br.com.caelum.ed.conjuntos.testes;

import java.util.List;

import ed1priscilla.br.com.caelum.ed.conjuntos.ConjuntoEspalhamento;

public class TesteExibePalavras {
    public static void main(String[] args) {

        /* novo conjunto */
        ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();

        /* adiciona 3 palavras */
        conjunto.adiciona("Mouse");
        conjunto.adiciona("Teclado");
        conjunto.adiciona("Monitor");

        /* pega as palavras e coloca-as em uma lista de strings */
        List<String> palavras = conjunto.pegaTodas();

        /* imprime cada uma das palavras da lista */
        for (String palavra : palavras ) {
            System.out.println(palavra);
        }
    }
}