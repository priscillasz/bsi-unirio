package ed1priscilla.br.com.caelum.ed.conjuntos.testes;

import java.util.HashSet;

public class TesteHashSet {
    public static void main(String[] args) {
        /* cria um novo hashset */
        HashSet conjunto = new HashSet();

        /* adiciona 4 elementos ao conjunto */
        conjunto.add("Priscilla");
        conjunto.add("Wallace");
        conjunto.add("Louise");
        conjunto.add("Mariana");

        /* impressão */
        System.out.println(conjunto);
    }
}