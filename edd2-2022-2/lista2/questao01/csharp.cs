using System;

public class CSharp {
	//Dois vetores: Método que imprime 2 vetores ao contrário - O(n + m)
    static void doisVetores(int[] vet1, int[] vet2) {  
		Console.WriteLine("Vetor 1:");
		for (int i = vet1.Length -1; i >= 0; i--){ //O(n)
			Console.WriteLine(vet1[i]);  
		}

		Console.WriteLine("\nVetor 2:");
		for (int j = vet2.Length -1; j >= 0; j--){ //O(m)
			Console.WriteLine(vet2[j]);  
		}
	}

	public static void Main() {
		int[] vet1 = {13, 25, 33, 99, 9, 11};
		int[] vet2 = {45, 33, 19, 87, 29, 35};
		
		doisVetores(vet1, vet2);
	}
}