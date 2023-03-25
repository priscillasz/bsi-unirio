package ed1priscilla.br.com.caelum.ed.listasligadas;

public class TesteRemoveDoFim {

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();

        lista.adiciona("Rogerio");
        lista.adiciona("Tamires");

        lista.removeDoFim();

        System.out.println(lista); // [Rogerio]
    }
}