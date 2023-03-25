package ed1priscilla.br.com.caelum.ed.pilhas.testes.generica;

import ed1priscilla.br.com.caelum.ed.pilhas.Peca;
import ed1priscilla.br.com.caelum.ed.pilhas.PilhaGenerica;

public class TesteEstaVaziaGenerica {

    public static void main(String[] args) {

        /* cria uma nova pilha generica */
        PilhaGenerica pilha = new PilhaGenerica();

        /* cria uma nova peça */
        Peca peca = new Peca();

        /* define o nome da peça */
        peca.setNome("Peça 1");

        /* insere peça na pilha */
        pilha.insere(peca);

        /* cria um novo objeto para armazenar a peça removida do topo da pilha */
        Object pecaRemovida = pilha.remove();

        /* verifica se a pilha está vazia */
        System.out.println("Pilha está vazia? " + pilha.vazia());
    }
}