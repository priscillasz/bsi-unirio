package ed1priscilla.br.com.caelum.ed.pilhas.testes.generica;

import ed1priscilla.br.com.caelum.ed.pilhas.Peca;
import ed1priscilla.br.com.caelum.ed.pilhas.PilhaGenerica;

public class TesteRemoveGenerica {

    public static void main(String[] args) {

        /* cria uma pilha generica */
        PilhaGenerica pilha = new PilhaGenerica();

        /* cria uma nova peça */
        Peca peca = new Peca();

        /* define nome da peça */
        peca.setNome("Transistor");

        /* insere peça na pilha generica */
        pilha.insere(peca);

        /* cria um objeto para armazenar a peça que foi removida da pilha */
        Object pecaRemovida = pilha.remove();

        /* verifica se a peça é igual a peça removida e se a pilha está vazia ou não */
        System.out.println(peca == pecaRemovida);
        System.out.println("peça removida, pilha está vazia: " + ((pilha.vazia() == true)));
    }
}
