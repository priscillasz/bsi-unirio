package ed1priscilla.br.com.caelum.ed.conjuntos;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ConjuntoEspalhamento {
    private static int COLUNAS = 26;
    private List<List<String>> tabela = new ArrayList<List<String>>(COLUNAS);

    private int tamanho = 0;

    /* construtor: percorre a quantidade de colunas, criando uma linkedlist de objetos e adicionando-a à tabela. */
    public ConjuntoEspalhamento() {
        for (int index = 0; index < COLUNAS; index++) {
            LinkedList<String> lista = new LinkedList<String>();
            tabela.add(lista);
        }
    }

    /* método que adiciona um objeto palavra na tabela. */
    public void adiciona(String palavra) {
        if(!contem(palavra)) {
            this.verificarCargaDaTabela();
            int indice = this.calculaIndiceDaTabela(palavra);
            List<String> lista = this.tabela.get(indice);
            lista.add(palavra);
            this.tamanho++;
        }
    }

    /* remove palavra do conjunto: se o conjunto contem a palavra, verifica a carga da tabela e calcula o indice da palavra
     * na tabela. cria uma lista de objetos que recebe o indice e remove a palavra dessa lista. por fim, decrementa o tamanho
     * do conjunto. */
    public void remove(String palavra) {
        if(this.contem(palavra)) {
            this.verificarCargaDaTabela();
            int indice = this.calculaIndiceDaTabela(palavra);
            List<String> lista = this.tabela.get(indice);
            lista.remove(palavra);
            this.tamanho--;
        }
    }

    /* verifica se uma palavra está contida no conjunto */
    public Boolean contem(String palavra) {
        int indice = this.calculaIndiceDaTabela(palavra);
        List<String> lista = this.tabela.get(indice);
        return lista.contains(palavra);
    }

    /* pega todas as palavras da tabela, cria uma lista do tipo de object e percorre a tabela, adicionando
     * cada uma das palavras a lista, retornando-a no final. */
    public List<String> pegaTodas() {
        List<String> palavras = new ArrayList<String>();
        for (int index = 0; index < this.tabela.size(); index++) {
            palavras.addAll(this.tabela.get(index));
        }
        return palavras;
    }

    /* retorna o tamanho do conjunto */
    public int tamanho() {
        return this.tamanho;
    }

    /* imprime: percorre a tabela, imprimindo colchetes e astericos */
    public void imprimeTabela() {
        for (List<String> lista : this.tabela) {
            System.out.print("[");
            for(int index = 0; index < lista.size(); index++) {
                System.out.print("*");
            }
            System.out.println("]");
        }
    }

    /* calcula o codigo de espalhamento de uma palavra: percorre a palavra e adiciona ao codigo 31 * codigo + caractere
     * da posição atual do loop. retorna o codigo ao final. */
    private int calculaCodigoDeEspalhamento(String palavra) {
        int codigo = 1;
        for (int index = 0; index < palavra.length(); index++) {
            /* numeric promotion
             * https://stackoverflow.com/questions/54402612/java-implicit-conversion-between-int-and-char
             * neste caso de opperacao entre inteiros e chars, o char e promovido para inteiro,
             * entao a operacao de soma é realizada
             * Exemplo = 31 * 1 + 48 (valor ascii do char ʽ0ʽ)
             *
             */
            codigo = 31 * codigo + palavra.charAt(index);
        }
        return codigo;
    }

    /* recebe uma palavra e gera um codigo de espalhamento (valor absoluto do hashcode da palavra)
     * retorna o resto da divisão do codigo de espalhamento pelo tamanho da tabela */
    private int calculaIndiceDaTabela(String palavra) {
        int codigoDeEspalhamento = Math.abs(this.calculaCodigoDeEspalhamento(palavra));
        return codigoDeEspalhamento % tabela.size();
    }

    /* apaga toda a tabela */
    private void limparTabela() {
        this.tabela.clear();
    }

    /* adiciona listas a tabela até preencher a nova capacidade inserida */
    private void adicionaListas(int novaCapacidade) {
        for (int index = 0; index < novaCapacidade; index++) {
            this.tabela.add(new LinkedList<String>());
        }
    }
    /* recebe uma lista de paalvras e adiciona todas as palavras dessa lista na tabela */
    private void adicionaTodas(List<String> palavras) {
        for ( String palavra : palavras ) { this.adiciona(palavra); }
    }

    /* recebe uma nova capacidade para a tabela > cria uma lista que recebe as palavras da tabela >
     * limpa a tabela > adiciona as listas > adiciona as palavras nas listas */
    private void redimensionaTabela(int novaCapacidade) {
        List<String> palavras = this.pegaTodas();
        this.limparTabela();
        this.adicionaListas(novaCapacidade);
        this.adicionaTodas(palavras);
    }

    /* checa se a carga da tabela é maior que 0.75 para que possa duplicar a capacidade
     * caso a carga seja menor que 0.25, diminui a capacidade pela metade */
    private void verificarCargaDaTabela() {
        int capacidade = this.tabela.size();
        double carga = (double) this.tamanho / capacidade;

        if (carga > 0.75) {
            this.redimensionaTabela(capacidade * 2);
        } else if (carga < 0.25) {
            this.redimensionaTabela(Math.max(capacidade / 2, 10));
        }
    }
}
