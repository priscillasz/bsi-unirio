package ed1priscilla.lista02;

public class Vetor_cod1_Priscilla {
    private Aluno[] alunos = new Aluno[100000];
    private int tamanho = 0; // contador

    public void adiciona(Aluno aluno) {
        garantaEspaco();

        alunos[tamanho] = aluno;
        tamanho++;

        /*for (int i = 0; i < this.alunos.length; i++) {
            if (this.alunos[i] == null) {
                this.alunos[i] = aluno;
                break;
            }
        }*/
    }

    // Questão 8
    public void adiciona(int posicao, Aluno aluno) {
        garantaEspaco();

        if (!this.posicaoValida(posicao)) {
            throw new IllegalArgumentException("Posicao inválida");
        }

        for (int i = this.tamanho-1; i >= posicao; i--) {
            this.alunos[i+1] = this.alunos[i];
        }

        this.alunos[posicao] = aluno;
        this.tamanho++;
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao <= this.tamanho;
    }


    // Questão 7
    public Aluno pega(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IllegalArgumentException("Posicao inválida");
        }
        return this.alunos[posicao];

    }

    // Questão 9
    public void remove(int posicao) {
        if (posicao < 0 || posicao > this.alunos.length) {
            throw new IllegalArgumentException("Posicao inválida");
        }

        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.alunos[i] = this.alunos[i + 1];
        }

        this.tamanho--;
    }

    // Questão 6
    public boolean contem(Aluno aluno) {
        for (int i = 0; i < this.tamanho; i++) {
            if (aluno.equals(this.alunos[i])) {
                return true;
            }
        }
        return false;

        /*for (int i = 0; i < this.tamanho; i++) {
            if (aluno == this.alunos[i]) {
                return true;
            }
        }
        return false;*/
    }

    // Questão 5
    public int tamanho() {
        return this.tamanho;
    }

    // Questão 10
    private void garantaEspaco() {
        if (this.tamanho == this.alunos.length) {
            Aluno[] novaArray = new Aluno[this.alunos.length * 2];
            for (int i = 0; i < this.alunos.length; i++) {
                novaArray[i] = this.alunos[i];
            }
            this.alunos = novaArray;
        }
    }

    // Questão 3
    public String toString() {
        if (this.tamanho == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < this.tamanho - 1; i++) {
            builder.append(this.alunos[i]);
            builder.append(", ");
        }
        builder.append(this.alunos[this.tamanho - 1]);
        builder.append("]");
        return builder.toString();
    }
}