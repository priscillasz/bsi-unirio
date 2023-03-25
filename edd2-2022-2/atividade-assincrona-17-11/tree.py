# Given the root of a binary search tree, and an integer k, return the kth smallest value (indexed) of all the values of the nodes in the tree.

# inorder traversal para procurar o k-th menor elemento em uma BST
# A BST node

class Node:

	def __init__(self, key):

		self.data = key
		self.left = None
		self.right = None

# função recursiva para inserir uma key em uma BST
def insert(root, x):

	if (root == None):
		return Node(x)
	if (x < root.data):
		root.left = insert(root.left, x)
	elif (x > root.data):
		root.right = insert(root.right, x)
	return root

# função para encontrar o kth maior elemento em uma bst
# count = número de nós já processados
def kthSmallest(root):

	global k

	# caso base
	if (root == None):
		return None

	# procura na subárvore esquerda
	left = kthSmallest(root.left)

    # se o menor kth for encontrado na subarvore esquerda, retorna
	if (left != None):
		return left

    # se o elemento atual é o menor, retorna
	k -= 1
	if (k == 0):
		return root

    # caso contrário, procura na subarvore direita
	return kthSmallest(root.right)

# função para encontrar o kth menor elemento na bst
def printKthSmallest(root):

	res = kthSmallest(root)

	if (res == None):
		print("Há menos que k nós na BST")
	else:
		print("O menor k-th elemento é ", res.data)

# Driver code
if __name__ == '__main__':

	root = None
	keys = [20, 8, 22, 4, 12, 10, 14]

	for x in keys:
		root = insert(root, x)

	k = 3

	printKthSmallest(root)

