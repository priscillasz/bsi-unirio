package ed1priscilla.br.com.caelum.ed.listasligadas;

public class Celula {
    private Celula proxima;
    private Celula anterior;

    private Object elemento;

    /* construtor da classe com ponteiro para a proxima celula */
    public Celula(Celula proxima, Object elemento) {
        this.setProxima(proxima);
        this.elemento = elemento;
    }

    /* construtor da classe, definindo apenas o elemento que estará na celula */
    public Celula(Object elemento) {
        this.elemento = elemento;
    }

    /* retorna a celula anterior */
    public Celula getAnterior() {
        return anterior;
    }

    /* define a celula anterior */
    public void setAnterior(Celula anterior) {
        this.anterior = anterior;
    }

    /* retorna a próxima celula */
    public Celula getProxima() {
        return proxima;
    }

    /* define a proxima celula */
    public void setProxima(Celula proxima) {
        this.proxima = proxima;
    }

    /* retorna o elemento */
    public Object getElemento() {
        return this.elemento;
    }
}
