package ed1priscilla.br.com.caelum.ed.pilhas;

import java.util.LinkedList;
import java.util.List;

// import br.com.caelum.ed.pilhas.Peca;

public class Pilha {

    // criação de uma linkedlist que armazena objetos do tipo Peca
    private List<Peca> pecas = new LinkedList<Peca>();

    public void insere(Peca peca) {
        this.pecas.add(peca);
    }

    /* método que remove uma peca da pilha */
    // lembre-se indices comecam em 0, entao é sempre tamanhoFisico - 1
    public Peca remove() {
        if (this.vazia()) {
            throw new IndexOutOfBoundsException("Pilha vazia");
        }
        return this.pecas.remove(this.pecas.size() - 1);
    }

    /* verifica se a pilha está vazia -> se a quantidade de pecas == 0, entao a retorna true. caso contrário, retorna false. */
    public boolean vazia() {
        return this.pecas.size() == 0;
    }
}