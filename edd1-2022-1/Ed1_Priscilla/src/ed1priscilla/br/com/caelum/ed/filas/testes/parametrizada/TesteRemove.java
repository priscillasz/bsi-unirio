package ed1priscilla.br.com.caelum.ed.filas.testes.parametrizada;

import ed1priscilla.br.com.caelum.ed.alunos.Aluno;
import ed1priscilla.br.com.caelum.ed.filas.FilaParametrizada;

public class TesteRemove {

    public static void main(String[] args) {

        FilaParametrizada <Aluno> fila = new FilaParametrizada<Aluno>();
        Aluno aluno = new Aluno();
        aluno.setNome("Teste");

        fila.insere(aluno);
        Aluno alunoRemovido = fila.remove();
        System.out.println("O aluno removido é igual "
                + "ao aluno inserido? " + aluno.equals(alunoRemovido));
    }
}
