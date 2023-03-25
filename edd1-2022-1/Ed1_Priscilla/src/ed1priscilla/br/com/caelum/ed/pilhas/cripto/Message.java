package ed1priscilla.br.com.caelum.ed.pilhas.cripto;

public class Message {

    public String texto = "";

    /* define o texto da mensagem */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /* retorna o texto da mensagem */
    public String getText() {
        return this.texto;
    }

    /* método que retorna o caractere de uma posição que foi passada por parametro. */
    public char getChartAt(int index) {
        return this.texto.charAt(index);
    }
}
