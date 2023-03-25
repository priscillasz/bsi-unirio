package ed1priscilla.br.com.caelum.ed.pilhas.testes;

import ed1priscilla.br.com.caelum.ed.pilhas.Peca;
import ed1priscilla.br.com.caelum.ed.pilhas.Pilha;

public class TesteNaoEstaVazia {

    public static void main(String[] args) {

        /* cria uma nova pilha */
        Pilha pilha = new Pilha();

        /* cria uma nova peça */
        Peca peca = new Peca();

        /* define o nome da peça */
        peca.setNome("Transistor");

        /* insere a peça na pilha */
        pilha.insere(peca);

        /* verifica se a pilha está vazia */
        System.out.println("pilha.vazia()");
        System.out.println(pilha.vazia());
    }
}