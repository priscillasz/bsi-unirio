package ed1priscilla.br.com.caelum.ed.pilhas.testes.generica;

import ed1priscilla.br.com.caelum.ed.pilhas.Peca;
import ed1priscilla.br.com.caelum.ed.pilhas.PilhaGenerica;

public class TesteInsereGenerica {

    public static void main(String[] args) {

        /* cria uma nova pilha generica */
        PilhaGenerica pilha = new PilhaGenerica();

        /* cria uma nova peça */
        Peca peca = new Peca();

        /* define o nome da peça */
        peca.setNome("Transistor");

        /* insere peça na pilha */
        pilha.insere(peca);

        /* verifica que a pilha não está vazia */
        System.out.println("Peça inserida, pilha não está vazia. " + ((pilha.vazia() == false)));
    }
}
