package ed1priscilla.br.com.caelum.ed.listasligadas;

public class ListaLigada {
    private Celula primeira;
    private Celula ultima;

    private int totalDeElementos;

    /* adiciona: método para adicionar novos elementos no final da lista.
     * se o total de elementos for = 0, adiciona o elemento no começo da lista;
     * caso contrário, é criada uma celula nova com o elemento e essa celula é ligada a celula anterior
     * com auxílio do ponteiro.
     * por fim, o contador de elementos é incrementado. */
    public void adiciona(Object elemento) {
        if (this.totalDeElementos == 0) {
            this.adicionaNoComeco(elemento);
        } else {
            Celula nova = new Celula(elemento);

            this.ultima.setProxima(nova);
            nova.setAnterior(this.ultima);
            this.ultima = nova;
            this.totalDeElementos++;
        }
    }

    /* adiciona: método para adicionar novos elementos em posições específicas da lista.
     * se a posicao do elemento a ser adicionado for = 0, ele é adicionado no começo da lista;
     * se a posicao for igual a quantidade total de elementos, ele é adicionado ao final;
     * caso contrário, as outras células são reordenadas de forma que o elemento possa ser adicionado
     * na posição requerida e as outras células continuem ligadas. */
    public void adiciona(int posicao, Object elemento) {
        if (posicao == 0) {
            this.adicionaNoComeco(elemento);
        } else if (this.totalDeElementos == posicao) {
            this.adiciona(elemento);
        } else {
            Celula proxima = this.pegaCelula(posicao);
            Celula anterior = proxima.getAnterior();

            Celula nova = new Celula(elemento);

            anterior.setProxima(nova);
            nova.setAnterior(anterior);
            nova.setProxima(proxima);
            proxima.setAnterior(nova);

            this.totalDeElementos++;
        }
    }

    /* pega: retorna um elemento de acordo com a posição informada. */
    public Object pega(int posicao) {
        return pegaCelula(posicao).getElemento();
    }

    /* remove: remove um elemento da lista através da posicao informada por parâmetro.
     * se a posição informada não estiver ocupada, é lançada uma exceção;
     * se a posição informada for = 0, o elemento do início é removido;
     * se a posição informada for = totaldeelementos-1, o elemento do fim é removido;
     * caso contrário, os elementos são reordenados de forma que a celula do elemento a ser removido
     * recebe o elememnto da proxima celula, até que todos estejam rearranjados.
     * por fim, o total de elementos é decrementado. */
    public void remove(int posicao){
        if (!celulaOcupada(posicao)) {
            throw new IllegalArgumentException("Posição inválida");
        }

        if (posicao == 0) {
            this.removeDoComeco();
        } else if (posicao == this.totalDeElementos - 1) {
            this.removeDoFim();
        } else {
            Celula atual = this.pegaCelula(posicao);
            Celula anterior = atual.getAnterior();
            Celula proxima = atual.getProxima();

            anterior.setProxima(proxima);
            proxima.setAnterior(anterior);

            this.totalDeElementos--;
        }
    }

    /* tamanho: retorna o tamanho da lista que é referente ao total de elementos existentes nela. */
    public int tamanho() {
        return this.totalDeElementos;
    }

    /* contem: checa se um objeto/elemento pertence a lista. para isso, a lista é percorrida por completo a
     * fim de encontrá-lo. se o elemento for encontrado, retorna true. caso contrário, retorna false.  */
    public boolean contem (Object o){
        for (int i = 0; i < this.totalDeElementos; i++) {
            if (o.equals(this.pegaCelula(i).getElemento())) {
                return true;
            }
        }

        return false;
    }

    /* adicionaNoComeço: adiciona o elemento no começo da lista. */
    public void adicionaNoComeco(Object elemento){
        if (this.totalDeElementos == 0) {
            Celula nova = new Celula(elemento);
            this.primeira = nova;
            this.ultima = nova;
        } else {
            // A nova célula aponta para a antiga primeira
            Celula nova = new Celula(this.primeira, elemento);

            // A antiga primeira célula aponta para a nova célula, que é o nova primeira
            this.primeira.setAnterior(nova);

            // A nova célula passa a ser a primeira da lista
            this.primeira = nova;
        }

        this.totalDeElementos++;
    }

    /* removeDoComeço: remove o primeiro elemento da lista */
    public void removeDoComeco() {
        if (!this.celulaOcupada(0)) {
            throw new IllegalArgumentException("Posição não existe");
        }

        this.primeira = this.primeira.getProxima(); // pode retornar null, o que esvaziará a lista
        this.totalDeElementos--;

        if (this.totalDeElementos == 0) {
            this.ultima = null;
        }
    }

    /* removeDoFim: remove o último elemento da lista */
    public void removeDoFim() {
        if (!celulaOcupada(0)) { // Se a lista já estiver vazia, lançe uma excecao
            throw new IllegalArgumentException("Posição não existe");
        } else if (this.totalDeElementos == 1) {
            this.removeDoComeco();
        } else {
            Celula penultima = this.ultima.getAnterior();
            penultima.setProxima(null);
            this.ultima = penultima;
            this.totalDeElementos--;
        }
    }

    /* toString: retorna uma string que representa a lista ligada. */
    public String toString() {
        if (this.totalDeElementos == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("[");

        Celula atual = this.primeira;

        for (int i = 0; i < this.totalDeElementos - 1; i++) {
            builder.append(atual.getElemento());
            builder.append(", ");
            atual = atual.getProxima();
        }

        builder.append(atual.getElemento());
        builder.append("]");

        return builder.toString();
    }

    /* celulaOcupada: retorna true se é a posição existir na lista e false se não existir (menor
     * que 0 ou maior que o total de elementos. */
    private boolean celulaOcupada(int posicao){
        return posicao >= 0 && posicao < this.totalDeElementos;
    }

    /* pegaCelula: retorna o nó, a celula da posição indicada por parâmetro. */
    private Celula pegaCelula(int posicao){
        if (!celulaOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }

        Celula atual = this.primeira;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProxima();
        }

        return atual; // Retorna a celula correspondente a posição indicada
    }
}