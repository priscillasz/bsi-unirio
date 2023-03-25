# Complexidade da função: O(n) * O(n) = O(nˆ2)
# Ao realizar o Selection Sort, tanto em Python quanto em Java a complexidade logarítmica no pior caso é O(nˆ2), já que o array pode ser percorrido duas vezes (com um loop dentro do outro). O próprio cálculo da complexidade é similar nesses casos

def selection_sort(arr):
    if not arr:
        return arr
    for i in range(len(arr)): # O(n)
        min_i = i
        for j in range(i + 1, len(arr)): # O(n)
            if arr[j] < arr[min_i]:
                min_i = j
        arr[i], arr[min_i] = arr[min_i], arr[i]