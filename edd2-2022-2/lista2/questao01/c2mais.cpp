// Programa em C++ para fazer o insertion sort
// Complexidade: O(n^2), pois há um loop sendo percorrido
// dentro
#include <iostream>

// função para ordenar array usando o insertion sort
void insertionSort(int arr[], int n) 
{ 
   int i, key, j; 
   for (i = 1; i < n; i++) 
   { 
       key = arr[i]; 
       j = i-1;

       // move elementos da arr[0..i-1] que são maiores a chave
        // para uma posição a frente da posição atual
       while (j >= 0 && arr[j] > key) 
       { 
           arr[j+1] = arr[j]; 
           j = j-1; 
       } 
       arr[j+1] = key; 
   } 
}

int main() {

  int n = 3;

  int arr[] = {30, 6, 1};

  insertionSort(arr, n);

  for (int i = 0; i < 3; i++){
    printf("%d ",arr[i]);
  }
}