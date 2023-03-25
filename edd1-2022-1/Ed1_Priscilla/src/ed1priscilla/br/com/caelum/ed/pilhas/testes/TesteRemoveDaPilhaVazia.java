package ed1priscilla.br.com.caelum.ed.pilhas.testes;

import ed1priscilla.br.com.caelum.ed.pilhas.Peca;
import ed1priscilla.br.com.caelum.ed.pilhas.Pilha;

public class TesteRemoveDaPilhaVazia {

    public static void main(String[] args) {

        /* cria uma nova pilha */
        Pilha pilha = new Pilha();

        /* bloco try catch */
        try {
            /* cria uma nova peça para armazenar a peça que foi removida do topo da pilha */
            Peca removida = pilha.remove();

            /* como a pilha está vazia, imprime uma exceção. */
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}