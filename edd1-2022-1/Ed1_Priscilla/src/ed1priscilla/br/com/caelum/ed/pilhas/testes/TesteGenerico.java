package ed1priscilla.br.com.caelum.ed.pilhas.testes;

import ed1priscilla.br.com.caelum.ed.pilhas.Peca;
import ed1priscilla.br.com.caelum.ed.pilhas.Pilha;

public class TesteGenerico {

    public static void main(String[] args) {

        /* cria uma nova pilha */
        Pilha pilha = new Pilha();

        /* cria uma nova peça */
        Peca peca = new Peca();
        Peca peca1 = new Peca();

        /* define nome da peça */
        peca.setNome("Transistor");
        peca1.setNome("Peça 1");
        /* insere peça na pilha */
        pilha.insere(peca);
        pilha.insere(peca1);

        /* cria uma nova peça para armazenar a peça que foi removida do topo da pilha */
        Peca pecaRemovida = pilha.remove();

        /* se a peça removida for diferente da peça que foi inserida na pilha, aponta que elas são diferentes */
        if( pecaRemovida != peca) {
            System.out.println("Erro: a peça removida não é igual " +
                    " a que foi inserida");
        }

        /* indica quando a pilha não está vazia */
        if (!pilha.vazia()) {
            System.out.println("Erro: A pilha não está vazia");
        }
    }
}