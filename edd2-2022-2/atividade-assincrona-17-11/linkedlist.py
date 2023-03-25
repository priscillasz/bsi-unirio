# - Delete all duplicate elements in a linked list
# deletar elementos duplicados em uma linked list ordenada

# classe nó
class Node:
	# construtor do nó
	def __init__(self, data):
		self.data = data
		self.next = None

class LinkedList:
	# inicializar a head da linked list
	def __init__(self):
		self.head = None

	# função para inserir um novo nó no início
	def push(self, new_data):
		new_node = Node(new_data)
		new_node.next = self.head
		self.head = new_node

    # dada uma referência para a head da lista e uma chave, 
    # deletar a primeira ocorrência da chave na linked list
	def deleteNode(self, key):
		
		# armazenar o nó head
		temp = self.head

        # se o nó head tiver a key, deve ser deletado
		if (temp is not None):
			if (temp.data == key):
				self.head = temp.next
				temp = None
				return

        # procura a key que vai ser deletada
		while(temp is not None):
			if temp.data == key:
				break
			prev = temp
			temp = temp.next

        # se a key não estiver presente na linked list
		if(temp == None):
			return

        # desconecta o nó da linked list
		prev.next = temp.next

		temp = None

    # função para imprimir a linked list
	def printList(self):
		temp = self.head
		while(temp):
			print(temp.data , end = ' ')
			temp = temp.next
	
    # função para remover duplicados da lista ordenada	
	def removeDuplicates(self):
		temp = self.head
		if temp is None:
			return
		while temp.next is not None:
			if temp.data == temp.next.data:
				new = temp.next.next
				temp.next = None
				temp.next = new
			else:
				temp = temp.next
		return self.head

# Driver Code
llist = LinkedList()

llist.push(20)
llist.push(13)
llist.push(13)
llist.push(11)
llist.push(11)
llist.push(11)
print ("Criar Linked List: ")
llist.printList()
print()
print("Linked list após remover elementos duplicados: ")
llist.removeDuplicates()
llist.printList()
