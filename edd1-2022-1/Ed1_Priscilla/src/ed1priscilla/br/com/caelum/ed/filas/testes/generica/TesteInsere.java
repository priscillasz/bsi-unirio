package ed1priscilla.br.com.caelum.ed.filas.testes.generica;

import ed1priscilla.br.com.caelum.ed.alunos.Aluno;
import ed1priscilla.br.com.caelum.ed.filas.FilaGenerica;

public class TesteInsere {

    public static void main(String[] args) {
        FilaGenerica filaDeAlunos = new FilaGenerica();
        Aluno aluno = new Aluno();
        aluno.setNome("Teste");

        filaDeAlunos.insere(aluno);

        System.out.println("filaDeAlunos.vazia(): " + filaDeAlunos.vazia());
    }
}
