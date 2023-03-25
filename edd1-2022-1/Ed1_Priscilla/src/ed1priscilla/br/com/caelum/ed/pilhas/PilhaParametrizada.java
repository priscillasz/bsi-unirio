package ed1priscilla.br.com.caelum.ed.pilhas;

import java.util.LinkedList;
import java.util.List;

public class PilhaParametrizada<T> {

    private List<T> objetos = new LinkedList<T>();

    /* método que insere um objeto genérico na pilha */
    public void insere(T t) {
        this.objetos.add(t);
    }

    /* método que remove um objeto genérico na pilha */
    public T remove() {
        if (this.vazia()) {
            throw new IndexOutOfBoundsException("Pilha vazia");
        }
        return this.objetos.remove(this.objetos.size() - 1);
    }

    /* verifica se a pilha está vazia -> se a quantidade de pecas == 0, entao a retorna true. caso contrário, retorna false. */
    public boolean vazia() {
        return this.objetos.size() == 0;
    }
}