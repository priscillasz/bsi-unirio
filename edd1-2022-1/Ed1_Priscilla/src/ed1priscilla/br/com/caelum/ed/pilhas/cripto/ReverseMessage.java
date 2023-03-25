package ed1priscilla.br.com.caelum.ed.pilhas.cripto;

public class ReverseMessage {

    private static String str = "";
    private static char c = ' ';

    /* método que reverte uma string recebida por parametro.
     * cada caractere da string é armazenado no char c e em seguida é somado na string auxiliar str.
     * isso acontece durante um loop que termina quando chega-se ao final do tamanho da string. */
    public static String reverse(String mensagem) {

        for (int i = mensagem.length() - 1; i >= 0; i--) {
            c = mensagem.charAt(i);
            str += c;
        }
        return str;
    }
}

