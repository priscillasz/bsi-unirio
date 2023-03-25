package ed1priscilla.br.com.caelum.ed.listasligadas;

public class TesteRemoveNoComeco {

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();

        lista.adiciona("Emerson");
        lista.adiciona("Danielly");

        System.out.println(lista); // [Emerson, Danielly]

        lista.removeDoComeco();

        System.out.println(lista); // [Danielly]
    }
}