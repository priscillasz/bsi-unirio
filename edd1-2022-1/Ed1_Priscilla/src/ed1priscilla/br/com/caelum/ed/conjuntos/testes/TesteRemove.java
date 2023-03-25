package ed1priscilla.br.com.caelum.ed.conjuntos.testes;

import java.util.List;

import ed1priscilla.br.com.caelum.ed.conjuntos.ConjuntoEspalhamento;

public class TesteRemove {
    public static void main(String[] args) {

        /* cria um novo conjunto */
        ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();

        /* adiciona elementos ao conjunto */
        conjunto.adiciona("palavra");
        conjunto.adiciona("computador");
        conjunto.adiciona("apostila");

        /* verifica o tamanho do conjunto */
        System.out.println("O tamanho do conjunto é 3? " + (conjunto.tamanho() == 3));

        /* cria uma lista de strings que recebe todas as palavras contidas no conjunto */
        System.out.println("Lista de palavras antes de remover:");
        List<String> palavras = conjunto.pegaTodas();

        /* imprime todas as palavras da lista de strings */
        for (String palavra : palavras) {
            System.out.println(palavra);
        }

        /* remove a palavra apostila */
        conjunto.remove("apostila");

        /* verifica o tamanho do conjunto */
        System.out.println("O tamanho do conjunto é 2? " + (conjunto.tamanho() == 2));

        /* recoloca todas as palavras do conjunto na lista de strings após remover uma palavra */
        System.out.println("Lista de palavras apos remover:");
        palavras = conjunto.pegaTodas();

        /* imprime todas as palavras da lista de strings */
        for (String palavra : palavras) {
            System.out.println(palavra);
        }
    }
}
