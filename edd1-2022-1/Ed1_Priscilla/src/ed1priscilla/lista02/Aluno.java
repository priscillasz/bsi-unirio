package ed1priscilla.lista02;

public class Aluno {
    private String nome;

    public Aluno() {
    }

    public Aluno(String nome) {
        this.nome = nome;
    }

    private String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return this.nome;
    }

    /*public boolean equals(Object o) {
        Aluno outro = (Aluno)o;
        return this.nome.equals(outro.nome);
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return nome.equals(aluno.nome);
    }
}