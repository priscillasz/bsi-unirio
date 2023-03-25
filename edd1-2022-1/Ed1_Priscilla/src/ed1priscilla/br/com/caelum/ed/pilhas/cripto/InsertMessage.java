package ed1priscilla.br.com.caelum.ed.pilhas.cripto;

import ed1priscilla.br.com.caelum.ed.pilhas.PilhaParametrizada;

public class InsertMessage {

    /* método que recebe uma string mensagem e uma pilha parametrizada do tipo caractere */
    public static void onStack(String message, PilhaParametrizada<Character> pilha) {

        // String reverseMessage = ReverseMessage.reverse(message);

        /* varre a string message, pegando o valor de cada caractere e armazenando no Character character,
         * inserindo cada um na pilha em seguida. */
        for (int index = 0; index < message.length(); index++) {
            Character character = WrapperChar.toCharacter(message.charAt(index));
            pilha.insere(character);
        }
    }
}