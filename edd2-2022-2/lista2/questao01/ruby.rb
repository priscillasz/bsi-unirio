#Converter uma frase em uma pilha

def impressaoContrario # O(n) + O(n) = O(n)
    frase = "Eu amodeio estrutura de dados"
    reverso = ''
    
    for i in 1..frase.length # O(n)
        reverso += frase[frase.length - i]
    end
    
    puts reverso # O custo de impressao tambem e O(n), se considerarmos o fato de uma string ser um vetor de caracteres
    
end

impressaoContrario()