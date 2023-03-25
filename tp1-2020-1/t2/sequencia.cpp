#include <stdio.h>

int const tam_vet = 100;

int main()
{
    int n, k;

    // Ler quantidade n de inteiros da sequencia 1
    puts("Qtd termos da sequencia 1");
    printf("N: ");
    scanf("%d", &n);

    // Checar se n e maior que 1
    if (n <= 1)
    {
        puts("Erro: Valor de N menor ou igual a 1.");
    }

    else
    {
        // Checar se n e maior que 100
        if (n > 100)
        {
            n = tam_vet;
        }

        // Criar a sequencia s1
        int s1[n];

        // Ler a sequencia 1
        puts("Sequencia 1");
        for (int i = 0; i < n; )
        {
            printf("s1[%d]: ", i);
            scanf("%d", &s1[i]);

            if (s1[i] >= 1 && s1[i] <= 100)
            {
                i++;
            }
        }
        
        putchar('\n');

        // Ler a quantidade k de inteiros da sequencia 2
        puts("Qtd termos da sequencia 2");
        printf("K: ");
        scanf("%d", &k);

        // Checar se k e maior que 1
        if (k <= 1)
        {
            puts("Erro: Valor de K menor ou igual a 1.");
        }
        
        else
        {
            // Checar se k e maior que 100
            if (k > 100)
            {
                k = tam_vet;
            }
            
            // Criar a sequencia s2
            int s2[k];

            // Ler a sequencia 2
            puts("Sequencia 2");
            for (int i = 0; i < k; )
            {
                printf("s2[%d]: ", i);
                scanf("%d", &s2[i]);

                if (s2[i] >= 1 && s2[i] <= 100)
                {
                    i++;
                }
            }

            putchar('\n');
            
            // Imprimir a sequencia 1
            printf("s1: [ ");
            for (int i = 0; i < n; i++)
            {
                printf("%d ", s1[i]);
            }
            printf("]");
            
            putchar('\n');

            // Imprimir a sequencia 2
            printf("s2: [ ");
            for (int i = 0; i < k; i++)
            {
                printf("%d ", s2[i]);
            }  
            printf("]");

            putchar('\n');

            // Checar se s2 esta em s1 de frente para tras
            int i = 0, j = 0;

            while (i < n && j < k) 
            {
                if (s1[i] == s2[j]) 
                {
                    i++;
                    j++;
                }

                else 
                {
                    i = i - j + 1;
                    j = 0;
                }  
            }
            
            if (j == k)
            {
                printf("s2 ocorre em s1 na posicao %d de frente para tras.\n", i-j);
                
            }

            else
            {
                // Checar se s2 esta em s1 de tras para frente
                i = n, j = 0;
                
                while (i >= 0 && j < k) 
                {
                    if (s1[i] == s2[j]) 
                    {
                        i--;
                        j++;

                        if (j == k)
                        {
                            printf("s2 ocorre em s1 na posicao %d de tras para frente.\n", i+j);
                        }
                    }

                    else 
                    {
                        i = i + j - 1;
                        j = 0;

                        // Se s2 nao estiver em s1 de frente para tras ou de tras para frente, imprimir:
                        if (i == 0 && j == 0)
                        {
                            printf("s2 nao encontrado em s1.\n");
                        }    
                    }
                } 
            }
        }
    }
}