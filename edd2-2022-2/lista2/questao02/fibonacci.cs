// Programa para descobrir o número x da sequência fibonacci
// Complexidade: O(n), pois há um loop que percorre o tamanho n da array para adicionar
// os numeros da sequência

using System;
class fibonacci {
	
static int fib(int n)
	{
        // declara uma array para armazenar os números fibonacci
		int []f = new int[n + 2];
		int i;
		
        // numeros da posição 0 e 1 da sequência fibonacci são definidos como 0 e 1
		f[0] = 0;
		f[1] = 1;
		
		for (i = 2; i <= n; i++) {
            // adiciona os 2 números anteriores da sequencia e armazena
			f[i] = f[i - 1] + f[i - 2];
		}
		
		return f[n];
	}
	
	public static void Main ()
	{
		int n = 9;
		Console.WriteLine(fib(n));
	}
}