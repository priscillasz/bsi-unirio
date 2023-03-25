package ed1priscilla.br.com.caelum.ed.filas;

import java.util.LinkedList;
import java.util.List;

public class FilaParametrizada<T> {

    /* criação de uma lista linkada que armazena objetos genéricos. */
    private List<T> objetos = new LinkedList<T>();

    /* método que insere um objeto genérico no final da fila. */
    public void insere(T t) {
        this.objetos.add(t);
    }

    /* remove: remove o objeto genérico que está na posição 0 da fila, ou seja, no início, o primeiro. */
    public T remove() {
        return this.objetos.remove(0);
    }

    /* vazia: verifica se a fila está vazia. true, caso o tamanho seja == 0 e false caso seja != 0. */
    public boolean vazia() {
        return this.objetos.size() == 0;
    }
}