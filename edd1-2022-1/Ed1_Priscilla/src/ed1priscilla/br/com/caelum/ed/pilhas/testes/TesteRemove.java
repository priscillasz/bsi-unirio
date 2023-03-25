package ed1priscilla.br.com.caelum.ed.pilhas.testes;

import ed1priscilla.br.com.caelum.ed.pilhas.Peca;
import ed1priscilla.br.com.caelum.ed.pilhas.Pilha;

public class TesteRemove {

    public static void main(String[] args) {

        /* cria uma nova pilha */
        Pilha pilha = new Pilha();

        /* cria uma nova peça */
        Peca peca = new Peca();

        /* define o nome da peça */
        peca.setNome("Transistor");

        /* insere a peça na pilha criada */
        pilha.insere(peca);

        /* cria uma nova peça para armazenar a peça que será removida do topo da pilha */
        Peca pecaRemovida = pilha.remove();

        /* imprime a peça que foi removida da pilha*/
        System.out.println("peca == pecaRemovida");
        System.out.println(peca == pecaRemovida);
    }
}
