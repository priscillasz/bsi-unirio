# Given an integer array that contains the elements 1 to 100 missing an element. How to find the missing element?
# Encontrar elemento que está faltando

# Solução: varrer a array, elemento por elemento, comparando cada um com o próximo elemento (i+1). se algum elemento não combinar, então conclui-se que o elemento que está faltando é o i+1

def findMissing(arr, N):

	# criar lista de zeros
	temp = [0] * (N+1)

	for i in range(0, N):
		temp[arr[i] - 1] = 1

	for i in range(0, N+1):
		if(temp[i] == 0):
			ans = i + 1

	print(ans)

# Driver code
if __name__ == '__main__':
    list = []
    for i in range(100):
        list.append(i)
    
    list.remove(4)
    N = len(list)

# chamada da função
findMissing(list, N)


