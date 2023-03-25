#include <stdio.h>

int main()
{
    char jogo[3][3];
    int i, j;
    int jogador;
    
    // Imprime o tabuleiro do jogo vazio
    for (i = 0; i < 3; i++)
    {      
        for (j = 0; j < 3; j++)
        {
            jogo[i][j] = '_';
            printf("%c", jogo[i][j]);
            printf(" ");
        }
        putchar('\n');
    }
    
    // Loop que verifica quando e a vez de cada jogador
    int linha, coluna;
    for (jogador = 1; jogador <= 9; jogador++)
    {
       if (jogador <= 8)
        {
             // Define qual jogador esta jogando
            if (jogador % 2 != 0)
            {
                printf("\nJOGADOR 1\n");
            }
            else
            {
                printf("\nJOGADOR 2\n");
            }

            // Le a jogada do jogador da vez
            do // Le a linha
            {
                printf("Linha: ");
                scanf("%d", &linha);
                
                if (linha < 1 || linha > 3)
                {
                    puts("Linha invalida");
                }
            } while (linha < 1 || linha > 3);
            linha--;

            do // Le a coluna
            {
                printf("Coluna: ");
                scanf("%d", &coluna);

                if (coluna < 1 || coluna > 3)
                {
                    puts("Coluna invalida");
                }
                
            } while (coluna < 1 || coluna > 3);
            coluna--;

            putchar('\n');

            // Confere se as coordenadas inseridas ja estao ocupadas
            if (jogo[linha][coluna] != '_')
            {
                puts("Posicao ja ocupada!");
                do
                {
                    printf("Linha: ");
                    scanf("%d", &linha);
                    
                    if (linha < 1 || linha > 3)
                    {
                        puts("Linha invalida");
                    }
                } while (linha < 1 || linha > 3);
                linha--;

                do
                {
                    printf("Coluna: ");
                    scanf("%d", &coluna);

                    if (coluna < 1 || coluna > 3)
                    {
                        puts("Coluna invalida");
                    }
                    
                } while (coluna < 1 || coluna > 3);
                coluna--;
            }
            
            // Verifica quais posicoes estao vazias 
            if (jogo[linha][coluna] == '_');
            {
                // Especifica o simbolo usado por cada jogador, sendo O para jogador 2 e X para jogador 1
                if (jogador % 2 != 0)
                {
                    jogo[linha][coluna] = 'X';  // Jogador 1
                }
                else
                {
                    jogo[linha][coluna] = 'O';  // Jogador 2
                }
                
                // Imprime o simbolo nas coordenadas indicadas pelo jogador
                for (i = 0; i < 3; i++)
                {
                    for (j = 0; j < 3; j++)
                    {
                        printf("%c", jogo[i][j]);
                        printf(" ");
                    }
                    putchar('\n');
                }
                
                // Checa se um dos jogadores ganhou e sai do loop, caso contrario o jogo continua
                if ((jogo[0][0] == jogo[1][1] && jogo[0][0] == jogo[2][2] && jogo[0][0] != '_') ||
                (jogo[0][0] == jogo[1][0] && jogo[0][0] == jogo[2][0] && jogo[0][0] != '_') ||
                (jogo[0][0] == jogo[0][1] && jogo[0][0] == jogo[0][2] && jogo[0][0] != '_') ||
                (jogo[0][1] == jogo[1][1] && jogo[0][1] == jogo[2][1] && jogo[0][1] != '_') ||
                (jogo[0][2] == jogo[1][2] && jogo[0][2] == jogo[2][2] && jogo[0][2] != '_') ||
                (jogo[1][0] == jogo[1][1] && jogo[1][0] == jogo[1][2] && jogo[1][0] != '_') ||
                (jogo[2][0] == jogo[2][1] && jogo[2][0] == jogo[2][2] && jogo[2][0] != '_') ||
                (jogo[2][0] == jogo[1][1] && jogo[2][0] == jogo[0][2] && jogo[2][0] != '_'))
                {
                    printf("\nJogador %d vence!", (jogador % 2 == 0) + 1);
                    break;
                }  
            }
        }
        putchar('\n');
        // Se jogador == 9, checa qual coordenada entre as 9 continua vazia (com '_') e imprime X no lugar
        if (jogador == 9)
        {
            // 1
            if (jogo[0][0] == '_')
            {
                jogo[0][0] = 'X';
                putchar('\n');
                for (i = 0; i < 3; i++)
                {
                    for (j = 0; j < 3; j++)
                    {
                        printf("%c", jogo[i][j]);
                        printf(" ");
                    }
                    putchar('\n');
                }
            }

            // 2
            else if (jogo[0][1] == '_')
            {
                jogo[0][1] = 'X';
                putchar('\n');
                for (i = 0; i < 3; i++)
                {
                    for (j = 0; j < 3; j++)
                    {
                        printf("%c", jogo[i][j]);
                        printf(" ");
                    }
                    putchar('\n');
                }
            }
            
            // 3
            else if (jogo[0][2] == '_')
            {
                jogo[0][2] = 'X';
                putchar('\n');
                for (i = 0; i < 3; i++)
                {
                    for (j = 0; j < 3; j++)
                    {
                        printf("%c", jogo[i][j]);
                        printf(" ");
                    }
                    putchar('\n');
                }
            }
          
            // 4
            else if (jogo[1][0] == '_')
            {
                jogo[1][0] = 'X';
                putchar('\n');
                for (i = 0; i < 3; i++)
                {
                    for (j = 0; j < 3; j++)
                    {
                        printf("%c", jogo[i][j]);
                        printf(" ");
                    }
                    putchar('\n');
                }
            }

            // 5
            else if (jogo[1][1] == '_')
            {
                jogo[1][1] = 'X';
                putchar('\n');
                for (i = 0; i < 3; i++)
                {
                    for (j = 0; j < 3; j++)
                    {
                        printf("%c", jogo[i][j]);
                        printf(" ");
                    }
                    putchar('\n');
                }
            }

            // 6
            else if (jogo[1][2] == '_')
            {
                jogo[1][2] = 'X';
                putchar('\n');
                for (i = 0; i < 3; i++)
                {
                    for (j = 0; j < 3; j++)
                    {
                        printf("%c", jogo[i][j]);
                        printf(" ");
                    }
                    putchar('\n');
                }
            }

            // 7
            else if (jogo[2][0] == '_')
            {
                jogo[2][0] = 'X';
                putchar('\n');
                for (i = 0; i < 3; i++)
                {
                    for (j = 0; j < 3; j++)
                    {
                        printf("%c", jogo[i][j]);
                        printf(" ");
                    }
                    putchar('\n');
                }
            }

            // 8
            else if (jogo[2][1] == '_')
            {
                jogo[2][1] = 'X';
                putchar('\n');
                for (i = 0; i < 3; i++)
                {
                    for (j = 0; j < 3; j++)
                    {
                        printf("%c", jogo[i][j]);
                        printf(" ");
                    }
                    putchar('\n');
                }
            }
            
            // 9
            else 
            {
                jogo[2][2] = 'X';
                putchar('\n');
                for (i = 0; i < 3; i++)
                {
                    for (j = 0; j < 3; j++)
                    {
                        printf("%c", jogo[i][j]);
                        printf(" ");
                    }
                    putchar('\n');
                }
            }

            // Checa se um dos jogadores ganhou ou se deu empate (velha), saindo do loop em seguida
            if ((jogo[0][0] == jogo[1][1] && jogo[0][0] == jogo[2][2] && jogo[0][0] != '_') ||
            (jogo[0][0] == jogo[1][0] && jogo[0][0] == jogo[2][0] && jogo[0][0] != '_') ||
            (jogo[0][0] == jogo[0][1] && jogo[0][0] == jogo[0][2] && jogo[0][0] != '_') ||
            (jogo[0][1] == jogo[1][1] && jogo[0][1] == jogo[2][1] && jogo[0][1] != '_') ||
            (jogo[0][2] == jogo[1][2] && jogo[0][2] == jogo[2][2] && jogo[0][2] != '_') ||
            (jogo[1][0] == jogo[1][1] && jogo[1][0] == jogo[1][2] && jogo[1][0] != '_') ||
            (jogo[2][0] == jogo[2][1] && jogo[2][0] == jogo[2][2] && jogo[2][0] != '_') ||
            (jogo[2][0] == jogo[1][1] && jogo[2][0] == jogo[0][2] && jogo[2][0] != '_'))
            {
                printf("\nJogador %d vence!", (jogador % 2 == 0) + 1);
                break;
            }

            else
            {
                printf("\nVelha!");
                break;
            }
        }
    }
}   
