package ed1priscilla.br.com.caelum.ed.pilhas.testes;

import ed1priscilla.br.com.caelum.ed.pilhas.Peca;
import ed1priscilla.br.com.caelum.ed.pilhas.Pilha;

public class TesteInsere {

    public static void main(String[] args) {

        /* cria uma nova pilha */
        Pilha pilha = new Pilha();

        /* novo objeto Peca*/
        Peca peca = new Peca();

        /* define nome da peça */
        peca.setNome("Transistor");

        /* insere a peça na pilha */
        pilha.insere(peca);

        /* impressão */
        System.out.println("peça inserida, pilha não está vazia " + ((pilha.vazia() == false )));
    }
}
