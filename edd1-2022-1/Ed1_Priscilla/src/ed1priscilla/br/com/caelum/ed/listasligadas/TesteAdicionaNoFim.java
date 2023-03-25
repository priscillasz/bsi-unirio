package ed1priscilla.br.com.caelum.ed.listasligadas;

public class TesteAdicionaNoFim {

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();

        Aluno a1 = new Aluno();
        Aluno a2 = new Aluno();

        a1.setNome("Douglas");
        a2.setNome("Maria");

        lista.adiciona(a1);
        lista.adiciona(a2);

        System.out.println(lista); // [Douglas, Maria]
    }
}