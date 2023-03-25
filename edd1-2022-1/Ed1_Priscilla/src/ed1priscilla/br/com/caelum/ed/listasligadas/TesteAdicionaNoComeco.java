package ed1priscilla.br.com.caelum.ed.listasligadas;

public class TesteAdicionaNoComeco {

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();

        lista.adicionaNoComeco("Maria");
        lista.adicionaNoComeco("Joao");

        System.out.println(lista); // [Joao, Maria]
    }
}
