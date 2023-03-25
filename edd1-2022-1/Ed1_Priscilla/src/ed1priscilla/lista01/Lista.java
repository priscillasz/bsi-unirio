package ed1priscilla.lista01;

public class Lista {
    protected Elo prim;
    protected class Elo {
        protected Aluno dado;
        protected Elo prox;
        public Elo(Aluno elem) {
            dado = elem;
            prox = null;
        }
    }
    public Lista() { prim = null; }
    public boolean vazia() { return prim == null; }
    public void insere(Aluno novo) {
        Elo p = new Elo(novo);
        p.prox = prim;
        prim = p;
    }
    public boolean busca(Aluno elem) {
        Elo p;
        for(p = prim; p != null; p = p.prox) {
            if(p.dado.getId() == elem.getId())
                return true;
        }
        return false;
    }
}
