package ed1priscilla.br.com.caelum.ed.pilhas.testes.parametrizadas;

import ed1priscilla.br.com.caelum.ed.pilhas.Peca;
import ed1priscilla.br.com.caelum.ed.pilhas.PilhaParametrizada;

public class TesteEstaVaziaParametrizada {

    public static void main(String[] args) {

        PilhaParametrizada<Peca> pilha = new PilhaParametrizada<Peca>();
        Peca peca = new Peca();
        peca.setNome("Teste");
        pilha.insere(peca);
        Peca pecaRemovida = pilha.remove();

        System.out.println("Pilha está vazia ? " + pilha.vazia());

    }
}
