package ed1priscilla.br.com.caelum.ed.listasligadas;

public class TesteAdicionaPorPosicao {

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();

        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();
        Aluno a3 = new Aluno();

        a1.setNome("Gabriel");
        a2.setNome("Marcos");
        a3.setNome("Leonardo");

        lista.adiciona(a1);
        lista.adiciona(a2);
        lista.adiciona(1, a3);

        System.out.println(lista); // [Leonardo, Gabriel, Marcos]
    }
}
