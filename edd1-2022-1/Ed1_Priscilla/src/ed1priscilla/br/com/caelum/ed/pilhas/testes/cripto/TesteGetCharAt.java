package ed1priscilla.br.com.caelum.ed.pilhas.testes.cripto;

import ed1priscilla.br.com.caelum.ed.pilhas.cripto.Message;

public class TesteGetCharAt {

    public static void main(String[] args) {
        /* criacao de uma nova mensagem */
        Message msg = new Message();

        /* define o texto da mensagem */
        msg.setTexto("Teste Teste Teste");

        /* criação de um novo caractere c que armazena o caractere da posição 1 da mensagem */
        char c = msg.getChartAt(1);
        System.out.println('e' == c);
    }
}