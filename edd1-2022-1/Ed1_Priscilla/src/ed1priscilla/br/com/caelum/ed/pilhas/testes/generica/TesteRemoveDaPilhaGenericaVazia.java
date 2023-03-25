package ed1priscilla.br.com.caelum.ed.pilhas.testes.generica;

import ed1priscilla.br.com.caelum.ed.pilhas.Peca;
import ed1priscilla.br.com.caelum.ed.pilhas.PilhaGenerica;

public class TesteRemoveDaPilhaGenericaVazia {

    public static void main(String[] args) {

        /* cria uma nova pilha generica */
        PilhaGenerica pilha = new PilhaGenerica();

        /* bloco try catch */
        try {
            /* cria um novo objeto para armazenar a peça que foi removida do topo da pilha */
            Object removida = pilha.remove();

            /* como a pilha está vazia, imprime uma exceção. */
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}
