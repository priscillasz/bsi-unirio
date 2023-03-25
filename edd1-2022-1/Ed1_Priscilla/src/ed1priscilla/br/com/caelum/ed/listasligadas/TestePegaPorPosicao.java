package ed1priscilla.br.com.caelum.ed.listasligadas;

public class TestePegaPorPosicao {

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();

        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();

        a1.setNome("Larissa");
        a2.setNome("Gilberto");

        lista.adiciona(a1);
        lista.adiciona(a2);

        System.out.println(lista.pega(0)); // Larissa
        System.out.println(lista.pega(1)); // Gilberto
    }
}