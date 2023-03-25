package ed1priscilla.br.com.caelum.ed.listasligadas;

public class TesteRemovePorPosicao {

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();

        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        Aluno a3 = new Aluno();

        a1.setNome("Jonas");
        a2.setNome("Fabio");
        a3.setNome("Ana");

        lista.adiciona(a1);
        lista.adiciona(a2);
        lista.adiciona(a3);

        System.out.println(lista); // [Jonas, Fabio, Ana]

        lista.remove(1);

        System.out.println(lista); // [Jonas, Ana]
    }
}