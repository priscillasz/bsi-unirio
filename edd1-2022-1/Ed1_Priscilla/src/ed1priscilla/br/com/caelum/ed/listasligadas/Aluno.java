package ed1priscilla.br.com.caelum.ed.listasligadas;

public class Aluno {
    private String nome;

    /* retorna o nome da instância */
    public String getNome() {
        return nome;
    }

    /* define um novo nome à instância */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /* retorna uma string que representa o objeto da classe Aluno */
    @Override
    public String toString() {
        return this.nome;
    }

    /* verifica se um objeto da classe Aluno é igual ao outro que foi passado por parâmetro. */
    @Override
    public boolean equals(Object o) {
        Aluno outro = (Aluno) o;
        // O nome agora é o novo critério de comparação
        return this.nome.equals(outro.nome);
    }
}