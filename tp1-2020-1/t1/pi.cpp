#include <stdio.h>

int main()
{
    int n;
    float pi = 0;
    int sinal = 1, mult = 1, divisor = 1;

    printf("Informe um numero N: ");
    scanf("%d", &n);

    if (n < 0)
    {
        puts("Valor invalido");
    }
    
    else
    {
        for (int i = 1; i <= n; i++)
        {
            pi += 3.4641016151377 * sinal * 1 / (divisor * mult);
            mult = mult * 3;
            sinal *= -1;
            divisor += 2;
        }

        printf("Pi = %.10f", pi);
    } 
}