package BST;

public class Main {
	public static void main(String args[]){
		ArvBinBuscaSChave<Integer> arvoreBinaria = new ArvBinBuscaSChave<>();
		
		arvoreBinaria.insere(10);
		arvoreBinaria.insere(20);
		arvoreBinaria.insere(5);
		arvoreBinaria.insere(2);
		arvoreBinaria.insere(4);
		arvoreBinaria.insere(18);
		arvoreBinaria.insere(22);
		
		//Imprimindo a �rvore em ordem
		arvoreBinaria.mostra();
		
		//Pulando uma linha
		System.out.println("\n");

		//Retornando o menor n� da �rvore - O (log n)
		System.out.println("A menor valor da �rvore �: " + arvoreBinaria.min());

		//Verificando se a �rvore contem um valor x - O (log n)
		if(arvoreBinaria.contem(18))
			System.out.println("O n� de valor 18 est� contido na �rvore.");
		else
			System.out.println("O n� de valor 18 n�o est� contido na �rvore.");

		//Verificando se a �rvore contem um valor x - O(log n)
		if(arvoreBinaria.contem(23))
			System.out.println("O n� de valor 23 est� contido na �rvore.");
		else
			System.out.println("O n� de valor 23 n�o est� contido na �rvore.");

		//Removendo o n� 20 da �rvore - O(log n)
		arvoreBinaria.delete(20);

		//Reimprimindo a �rvore ap�s a remo��o do n� 20 - O(n)
		System.out.println("\n");
		System.out.println("Impress�o da �rvore ap�s remover o n� de valor 20:");
		arvoreBinaria.mostra();
	}
}
