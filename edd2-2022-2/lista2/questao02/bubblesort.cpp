// Programa em c++ que implementa o algoritmo bubble sort
// Complexidade: O(n^2), pois há um loop interno sendo percorrido 
// dentro de outro loop do mesmo tamanho.

#include <bits/stdc++.h>
using namespace std;

// Função que implementa bubble sort
void bubbleSort(int arr[], int n)
{
	int i, j;
	for (i = 0; i < n - 1; i++) // O(n)
        // último elementos i já estão no lugar
		for (j = 0; j < n - i - 1; j++) // O(n)
			if (arr[j] > arr[j + 1])
				swap(arr[j], arr[j + 1]);

    // O(n^2) = O(n) * O(n) 
}

// Imprime uma array
void printArray(int arr[], int size)
{
	int i;
	for (i = 0; i < size; i++)
		cout << arr[i] << " ";
	cout << endl;
}

int main()
{
	int arr[] = { 5, 1, 4, 2, 8};
	int N = sizeof(arr) / sizeof(arr[0]);
	bubbleSort(arr, N);
	cout << "Sorted array: \n";
	printArray(arr, N);
	return 0;
}
