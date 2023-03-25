// Complexidade do método: O(n) * O(n) = O(nˆ2)
// Ao realizar o Selection Sort, tanto em Python quanto em Java a complexidade logarítmica no pior caso é O(nˆ2), já que o array pode ser percorrido duas vezes (com um loop dentro do outro). O próprio cálculo da complexidade é similar nesses casos

public class SelectionSort {
    public void selectionsort(int array[]) {
        int n = array.length;            //método para calcular o tamanho do array 
        for (int i = 0; i < n-1; i++) // O(n)
        {
            int index = i;
            int min = array[i];          // tomando o elemento min como i-ésimo elemento do array
            for (int j = i+1; j < n; j++) // O(n)
            {
                if (array[j] < array[index])
                {
                    index = j;
                    min = array[j];
                }
            }
            int t = array[index];         //Troque os elementos de lugar
            array[index] = array[i];
            array[i] = t;
        }
    }
}