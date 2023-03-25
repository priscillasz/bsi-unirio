package ed1priscilla.br.com.caelum.ed.filas;

import java.util.LinkedList;
import java.util.List;

public class FilaGenerica {

    /* criação de uma lista linkada que armazena objetos de qualquer tipo. */
    private List<Object> objetos = new LinkedList<Object>();

    /* método que insere um objeto no final da fila. */
    public void insere(Object objeto) {
        objetos.add(objeto);
    }

    /* remove: remove o objeto que está na posição 0 da fila, ou seja, no início, o primeiro. */
    public Object remove() {
        return this.objetos.remove(0);
    }

    /* vazia: verifica se a fila está vazia. true, caso o tamanho seja == 0 e false caso seja != 0. */
    public Boolean vazia() {
        return this.objetos.size() == 0;
    }

}