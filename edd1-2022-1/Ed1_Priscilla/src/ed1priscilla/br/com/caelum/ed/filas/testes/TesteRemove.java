package ed1priscilla.br.com.caelum.ed.filas.testes;

import ed1priscilla.br.com.caelum.ed.alunos.Aluno;
import ed1priscilla.br.com.caelum.ed.filas.Fila;

public class TesteRemove {

    public static void main(String[] args) {
        Fila fila = new Fila();

        Aluno aluno = new Aluno();

        fila.insere(aluno);

        System.out.println("fila vazia? " + fila.vazia());

        Aluno alunoRemovido = fila.remove();
        System.out.println("alunoRemovido == aluno");
        System.out.println(alunoRemovido == aluno);
    }
}