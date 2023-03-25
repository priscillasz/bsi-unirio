package ed1priscilla.br.com.caelum.ed.filas;

import java.util.LinkedList;
import java.util.List;

import ed1priscilla.br.com.caelum.ed.alunos.Aluno;

public class Fila {

    /* criação de uma lista linkada que armazena apenas objetos do tipo Aluno. */
    private List<Aluno> alunos = new LinkedList<Aluno>();

    /* método que insere um aluno no final da fila. */
    public void insere(Aluno aluno) {
        this.alunos.add(aluno);
    }

    /* remove: remove o aluno que está na posição 0 da fila, ou seja, no início, o primeiro. */
    public Aluno remove() {
        return this.alunos.remove(0);
    }

    /* vazia: verifica se a fila está vazia. true, caso o tamanho seja == 0 e false caso seja != 0. */
    public Boolean vazia() {
        return this.alunos.size() == 0;
    }

}