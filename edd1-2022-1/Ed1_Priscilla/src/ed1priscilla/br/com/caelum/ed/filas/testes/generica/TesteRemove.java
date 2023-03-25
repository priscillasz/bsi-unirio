package ed1priscilla.br.com.caelum.ed.filas.testes.generica;

import ed1priscilla.br.com.caelum.ed.alunos.Aluno;
import ed1priscilla.br.com.caelum.ed.filas.FilaGenerica;

public class TesteRemove {

    public static void main(String[] args) {
        FilaGenerica filaDeAlunos = new FilaGenerica();
        Aluno aluno = new Aluno();

        filaDeAlunos.insere(aluno);
        System.out.println("filaDeAlunos.vazia(): " + filaDeAlunos.vazia());

        Object alunoRemovido = filaDeAlunos.remove();
        System.out.println("aluno == alunoRemovido: " + ( aluno == (Aluno)alunoRemovido ) );

        System.out.println("filaDeAlunos.vazia(): " + filaDeAlunos.vazia());
    }
}
