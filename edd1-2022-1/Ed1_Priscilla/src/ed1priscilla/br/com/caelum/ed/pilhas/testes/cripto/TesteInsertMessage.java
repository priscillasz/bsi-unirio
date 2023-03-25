package ed1priscilla.br.com.caelum.ed.pilhas.testes.cripto;

import ed1priscilla.br.com.caelum.ed.pilhas.cripto.InsertMessage;
import ed1priscilla.br.com.caelum.ed.pilhas.cripto.Message;
import ed1priscilla.br.com.caelum.ed.pilhas.cripto.ReverseMessage;
import ed1priscilla.br.com.caelum.ed.pilhas.PilhaParametrizada;

public class TesteInsertMessage {

    public static void main(String[] args) {

        /* criação de uma pilha parametrizada do tipo Character*/
        PilhaParametrizada <Character> pilha = new PilhaParametrizada<Character>();

        /* criação de uma nova mensagem */
        Message message = new Message();

        /* define o texto da mensagem */
        message.setTexto("Teste");

        /* insere a mensagem na pilha */
        InsertMessage.onStack(message.getText(), pilha);

        /* string vazia para armazenar a mensagem recuperada */
        String messageCriptRecovered = "";

        /* enquanto a pilha não estiver vazia, vai removendo os caracteres da pilha e adicionando eles na string
         * da mensagem recuperada */
        while(!pilha.vazia()) {
            Character character = pilha.remove();
            messageCriptRecovered += character;
        }

        /* verifica se a string etseT é igual a messagem recuperada */
        System.out.println("etseT.equals(messageRecovered)");
        System.out.println("etseT".equals(messageCriptRecovered));

        System.out.println("");

        /* string para reverter a ordem da string recuperada */
        String messageUncriptRecovered = ReverseMessage.reverse(messageCriptRecovered);

        /* verifica se Teste é igual a string recuperada */
        System.out.println("Teste.equals(uncript)");
        System.out.println("Teste".equals(messageUncriptRecovered));
    }
}


