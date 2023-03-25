package ed1priscilla.br.com.caelum.ed.listasligadas;

public class TesteContemElemento {

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();

        lista.adiciona("Bianca");

        System.out.println(lista.contem("Bianca")); // true
        System.out.println(lista.contem("Paulo")); // false

        lista.adiciona("Paulo");

        System.out.println(lista.contem("Bianca")); // true
        System.out.println(lista.contem("Paulo")); // true
    }
}