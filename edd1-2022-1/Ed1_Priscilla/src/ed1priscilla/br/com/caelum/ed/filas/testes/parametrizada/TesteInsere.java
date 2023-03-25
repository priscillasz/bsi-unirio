package ed1priscilla.br.com.caelum.ed.filas.testes.parametrizada;

import ed1priscilla.br.com.caelum.ed.alunos.Aluno;
import ed1priscilla.br.com.caelum.ed.filas.FilaParametrizada;

public class TesteInsere {

    public static void main(String[] args) {

        FilaParametrizada<Aluno> fila = new FilaParametrizada<Aluno>();
        Aluno aluno = new Aluno();
        fila.insere(aluno);
        System.out.println("A fila está vazia? " + fila.vazia());
    }
}

