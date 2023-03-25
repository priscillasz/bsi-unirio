package ed1priscilla.br.com.caelum.ed.conjuntos.testes;

import ed1priscilla.br.com.caelum.ed.conjuntos.ConjuntoEspalhamento;

public class TesteContem {
    public static void main(String[] args) {
        /* cria um novo conjunto */
        ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();

        /* criação de duas strings */
        String palavraExistente = "Priscilla";
        String palavraInexistente = "Letícia";

        /* adiciona a string existente ao conjunto */
        conjunto.adiciona(palavraExistente);

        /* verifica se a string existente está contida no conjunto */
        System.out.println("conjunto.contem(Priscilla)");
        System.out.println(conjunto.contem(palavraExistente));

        /* verifica se a string inexistente está contida no conjunto */
        System.out.println("conjunto.contem(Letícia)");
        System.out.println(conjunto.contem(palavraInexistente));
    }
}