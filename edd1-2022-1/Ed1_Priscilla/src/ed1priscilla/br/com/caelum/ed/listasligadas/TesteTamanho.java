package ed1priscilla.br.com.caelum.ed.listasligadas;

public class TesteTamanho {

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();

        lista.adiciona("Xuxa");
        lista.adiciona("Jose");

        System.out.println(lista.tamanho()); // 2

        lista.adiciona("Tania");

        System.out.println(lista.tamanho()); // 3
    }
}