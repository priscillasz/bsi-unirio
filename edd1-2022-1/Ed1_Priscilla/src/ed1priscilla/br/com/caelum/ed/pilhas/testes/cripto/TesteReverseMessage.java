package ed1priscilla.br.com.caelum.ed.pilhas.testes.cripto;

import ed1priscilla.br.com.caelum.ed.pilhas.cripto.ReverseMessage;

public class TesteReverseMessage {

    public static void main(String[] args) {

        /* criacao de string */
        String str = "casa";

        /* string reversa */
        String reversed = ReverseMessage.reverse(str);
        System.out.println(reversed);
        System.out.println("reversed == asac");

        /* compara a string revertida */
        System.out.println(reversed.equals("asac"));
    }
}
