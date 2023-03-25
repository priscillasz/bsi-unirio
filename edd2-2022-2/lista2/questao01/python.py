# Programa para contar as inversões em uma array em Python
# Complexidade: O(n * log n), pois o merge sort é utilizado, que é um algoritmo recursivo.

# Função para usar a contagem de inversões
def mergeSort(arr, n):
    # Uma array temporária é criada para armazenar a array ordenada na função merge
    temp_arr = [0]*n
    return _mergeSort(arr, temp_arr, 0, n-1)
 
# Função que usa mergeSorte para contar inversões
def _mergeSort(arr, temp_arr, left, right):
    # variável que armazena a contagem de inversões em cada chamada recursiva
    inv_count = 0

    # chamada recursiva é feita se e somente se tiver mais de um elemento
    if left < right:
        # meio é calculado para dividir a array em duas subarrays
        mid = (left + right)//2

        # calcula contagem de inversões na subarray da esquerda
        inv_count += _mergeSort(arr, temp_arr,
                                left, mid)
 
        # calcula a contagem de inversões na subarray da direita
        inv_count += _mergeSort(arr, temp_arr,
                                mid + 1, right)
 
     
        # faz o merge das duas subarrays em uma subarray ordenada
        inv_count += merge(arr, temp_arr, left, mid, right)
    return inv_count
 
 
# função que faz o merge/junção de duas subarrays em uma única subarray ordenada
def merge(arr, temp_arr, left, mid, right):
    i = left     # index inicial da subarray da esquerda
    j = mid + 1  # index inicial da subarray da direita
    k = left     # index inicial da subarray a ser ordenada
    inv_count = 0
 
    # condições são checadas para ter certeza que i e j 
    # não excedem o limite das suas subarrays
    while i <= mid and j <= right:
        # inversão não ocorre se arr[i] <= arr[j]
        if arr[i] <= arr[j]:
            temp_arr[k] = arr[i]
            k += 1
            i += 1
        else:
            # caso contrário, a inversão ocorre
            temp_arr[k] = arr[j]
            inv_count += (mid-i + 1)
            k += 1
            j += 1
 
    # copia os elementos restantes da subarray esquerda para uma array temporária
    while i <= mid:
        temp_arr[k] = arr[i]
        k += 1
        i += 1
 
    # copia os elementos restantes da subarray direita para uma array temporária
    while j <= right:
        temp_arr[k] = arr[j]
        k += 1
        j += 1
 
    # copia a subarray ordenada para a array original
    for loop_var in range(left, right + 1):
        arr[loop_var] = temp_arr[loop_var]
 
    return inv_count
 
 
# Driver Code
# Array
arr = [1, 20, 6, 4, 5]
n = len(arr)
result = mergeSort(arr, n)
print("O número de inversões é ", result)
