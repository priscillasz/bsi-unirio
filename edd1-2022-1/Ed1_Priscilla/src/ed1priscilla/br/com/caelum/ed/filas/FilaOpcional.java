package ed1priscilla.br.com.caelum.ed.filas;

import java.util.ArrayList;

public class FilaOpcional<T> {

    /* criação de uma arraylist genérica */
    private ArrayList<T> objetos = new ArrayList<T>();

    /* método que insere um objeto genérico no final da fila. */
    public void insere(T t) {
        this.objetos.add(t);
    }

    /* remove: remove o objeto genérico que está na posição 0 da fila, ou seja, no início, o primeiro. */
    public T remove() {
        return this.objetos.remove(0);
    }

    /* vazia: verifica se a fila está vazia. true, caso o tamanho seja == 0 e false caso seja != 0. */
    public Boolean vazia() {
        return this.objetos.size() == 0;
    }

}