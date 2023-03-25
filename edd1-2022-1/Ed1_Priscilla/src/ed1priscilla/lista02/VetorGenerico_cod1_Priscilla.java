package ed1priscilla.lista02;

// Questão 11

public class VetorGenerico_cod1_Priscilla {

    private Object[] objetos = new Object[100];
    private int tamanho = 0;

    public void adiciona(Object objeto) {
        garantaEspaco();
        this.objetos[this.tamanho] = objeto;
        this.tamanho++;
    }

    public void adiciona(int posicao, Aluno aluno) {
        garantaEspaco();
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IllegalArgumentException("Posicao inválida");
        }
        for (int i = this.tamanho-1; i >= posicao; i--) {
            this.objetos[i + 1] = this.objetos[i];
        }
        this.objetos[posicao] = aluno;
        tamanho++;
    }

    public Object pega(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IllegalArgumentException("Posicao inválida");
        }
        return this.objetos[posicao];
    }

    public void remove(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IllegalArgumentException("Posicao inválida");
        }
        for (int i = posicao; i < this.tamanho-1; i++) {
            this.objetos[i] = this.objetos[i + 1];
        }
        tamanho--;
    }

    public boolean contem(Aluno aluno) {
        for (int i = 0; i < this.tamanho; i++) {
            if (aluno.equals(this.objetos[i])) {
                return true;
            }
        }
        return false;
    }

    public int tamanho() {
        return this.tamanho;
    }

    private void garantaEspaco() {
        if (this.tamanho == this.objetos.length) {
            Object[] novaArray = new Object[this.objetos.length * 2];
            for (int i = 0; i < this.objetos.length; i++) {
                novaArray[i] = this.objetos[i];
            }
            this.objetos = novaArray;
        }
    }
}

