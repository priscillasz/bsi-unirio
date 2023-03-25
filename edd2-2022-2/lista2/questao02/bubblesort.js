// implementação do bubble sort em javascript
// Complexidade: O(n^2), pois há um loop interno sendo percorrido 
// dentro de outro loop do mesmo tamanho.

function swap(arr, xp, yp)
{
	var temp = arr[xp];
	arr[xp] = arr[yp];
	arr[yp] = temp;
}

// An optimized version of Bubble Sort
function bubbleSort( arr, n)
{
    var i, j;
    for (i = 0; i < n-1; i++) // O(n)
    {
        for (j = 0; j < n-i-1; j++) // O(n)
        {
            if (arr[j] > arr[j+1])
            {
            swap(arr,j,j+1);
            
            }
        }

        // O(n^2) = O(n) * O(n) 
    }
}

/* Function to print an array */
function printArray(arr, size)
{
	var i;
	for (i=0; i < size; i++)
		document.write(arr[i]+ " ");
	document.write("\n");
}

// Driver program to test above functions
var arr = [64, 34, 25, 12, 22, 11, 90];
	var n = 7;
	document.write("UnSorted array: \n");
	printArray(arr, n);

	bubbleSort(arr, n);
	document.write("Sorted array: \n");
	printArray(arr, n);

