package ed1priscilla.br.com.caelum.ed.pilhas.testes.generica;

import ed1priscilla.br.com.caelum.ed.pilhas.Peca;
import ed1priscilla.br.com.caelum.ed.pilhas.PilhaGenerica;

public class TesteNaoEstaVaziaGenerica {

    public static void main(String[] args) {

        /* cria uma nova pilha generica */
        PilhaGenerica pilha = new PilhaGenerica();

        /* cria uma nova peça */
        Peca peca = new Peca();

        /* define um nome para a peça */
        peca.setNome("Teste");

        /* insere a peça na pilha */
        pilha.insere(peca);

        /* cria um novo objeto para armazenar a peça removida do topo da pilha */
        Object pecaRemovida = pilha.remove();

        /* insere o objeto com a peça removida na pilha */
        pilha.insere(pecaRemovida);

        /* verifica se a pilha está vazia */
        System.out.println("pilha.vazia()");
        System.out.println(pilha.vazia());
    }
}
