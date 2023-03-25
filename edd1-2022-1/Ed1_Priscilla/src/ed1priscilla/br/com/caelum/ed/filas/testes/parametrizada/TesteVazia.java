package ed1priscilla.br.com.caelum.ed.filas.testes.parametrizada;

import ed1priscilla.br.com.caelum.ed.alunos.Aluno;
import ed1priscilla.br.com.caelum.ed.filas.FilaParametrizada;

public class TesteVazia {
    public static void main(String[] args) {
        FilaParametrizada <Aluno> fila = new FilaParametrizada<Aluno>();
        System.out.println("Fila esta vazia? " + fila.vazia());
    }
}
