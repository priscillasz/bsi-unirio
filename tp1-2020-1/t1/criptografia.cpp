#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int main() 
{
    srand(time(NULL));
    int k = rand() % 9 + 1;

    long long cpf, cpf_criptografado;
    long long cpf_cripto, primeira_parte, ultimo_digito;

    printf("CPF (11 digitos): ");
    scanf("%lld", &cpf);

    if (cpf > 9999999999 && cpf <= 99999999999)
    {
        // Cada digito do CPF
        long long primeiro = cpf / 10000000000;
        long long segundo = (cpf / 1000000000) % 10;
        long long terceiro = (cpf / 100000000) % 10;
        long long quarto = (cpf / 10000000) % 10;
        long long quinto = (cpf / 1000000) % 10;
        long long sexto = (cpf / 100000) % 10;
        long long setimo = (cpf / 10000) % 10;
        long long oitavo = (cpf / 1000) % 10;
        long long nono = (cpf / 100) % 10;
        long long decimo = (cpf / 10) % 10;
        long long decimop = cpf % 10;

        // Reordenar o numero com o primeiro digito no meio, os 5 ultimos invertidos na frente e os 5 primeiros invertidos no final
        cpf_cripto = decimop * 10000000000 + decimo * 1000000000 + nono * 100000000 + oitavo * 10000000 + setimo * 1000000 + primeiro * 100000 + sexto * 10000 + quinto * 1000 + quarto * 100 + terceiro * 10 + segundo;

        // Girar o numero k vezes
        int i = 1;

        while (i <= k) 
        {
            primeira_parte = cpf_cripto / 10;
            ultimo_digito = cpf_cripto % 10;
            cpf_cripto = primeira_parte + ultimo_digito * 10000000000;
            i++;
        }
        
        // Adicionar o k ao final do CPF criptografado
        cpf_criptografado = cpf_cripto * 10 + k;
        
        printf("CPF criptografado: %lld\n", cpf_criptografado);
    }
    
    else
    {
        puts("Erro: Numero de CPF invalido");
    }
    
}