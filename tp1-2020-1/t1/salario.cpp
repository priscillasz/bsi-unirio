#include <stdio.h>

int main()
{
    int qtd_funcionarios, horas_trabalhadas;
    int horas_contratadas, anos_experiencia, horas_extras;
    float desconto_inss, desconto_ir;
    float salario_bruto, salario_liquido, salario_pos_inss;
    int funcao;

    printf("Informe a quantidade de funcionarios: ");
    scanf("%d", &qtd_funcionarios);

    for (int i = 1; i <= qtd_funcionarios; i++)
    {
        printf("\n");
        printf("--DADOS DO FUNCIONARIO %d--:\n", i);
        printf("Horas contratadas: ");
        scanf("%d", &horas_contratadas);

        printf("Horas trabalhadas: ");
        scanf("%d", &horas_trabalhadas);

        printf("Anos de experiencia: ");
        scanf("%d", &anos_experiencia);

        printf("Funcao (1- Programador 2 - Analista 3 - Gerente): ");
        scanf("%d", &funcao);

        // HORAS TRABALHADAS <= HORAS CONTRATADAS
        if (horas_trabalhadas <= horas_contratadas)
        {
            horas_extras = 0;

            if (funcao == 1)
            {
                if (anos_experiencia <= 2)
                {
                    salario_bruto = 25 * horas_trabalhadas;
                }
                
                else if (anos_experiencia >= 3 && anos_experiencia <= 5)
                {
                    salario_bruto = 30 * horas_trabalhadas;
                }
                
                else
                {
                    salario_bruto = 38 * horas_trabalhadas;
                }
            }

            else if (funcao == 2)
            {
                if (anos_experiencia <= 2)
                {
                    salario_bruto = 45 * horas_trabalhadas;
                }
                
                else if (anos_experiencia >= 3 && anos_experiencia <= 5)
                {
                    salario_bruto = 55 * horas_trabalhadas;
                }

                else
                {
                    salario_bruto = 70 * horas_trabalhadas;
                }
            }

            else if (funcao == 3)
            {
                if (anos_experiencia <= 2)
                {
                    salario_bruto = 85 * horas_trabalhadas;
                }
                
                else if (anos_experiencia >= 3 && anos_experiencia <=5)
                {
                    salario_bruto = 102 * horas_trabalhadas;
                }

                else
                {
                    salario_bruto = 130 * horas_trabalhadas;
                } 
            }        
        }

        // HORAS TRABALHADAS > HORAS CONTRATADAS
        else
        {
            horas_extras = horas_trabalhadas - horas_contratadas;

            if (horas_extras <= 13) // 23%
            {
                if (funcao == 1)
                {
                    if (anos_experiencia <= 2)
                    {
                        salario_bruto = (25 * horas_contratadas) + horas_extras * (25 + 25 * 0.23);
                    }

                    else if (anos_experiencia > 2 && anos_experiencia <= 5)
                    {
                        salario_bruto = (30 * horas_contratadas) + horas_extras * (30 + 30 * 0.23);
                    }

                    else
                    {
                        salario_bruto = (38 * horas_contratadas) + horas_extras * (38 + 38 * 0.23);
                    }
                }

                else if (funcao == 2)
                {
                    if (anos_experiencia <= 2) 
                    {
                        salario_bruto = (45 * horas_contratadas) + horas_extras * (45 + 45 * 0.23);
                    }
                    
                    else if (anos_experiencia >= 3 && anos_experiencia <= 5)
                    {
                        salario_bruto = (55 * horas_contratadas) + horas_extras * (55 + 55 * 0.23);
                    }

                    else
                    {
                        salario_bruto = (70 * horas_contratadas) + horas_extras * (70 + 70 * 0.23);
                    }
                }

                else if (funcao == 3)
                {
                    if (anos_experiencia <= 2)
                    {
                        salario_bruto = (85 * horas_contratadas) + horas_extras * (85 + 85 * 0.23);
                    }

                    else if (anos_experiencia >= 3 && anos_experiencia <= 5)
                    {
                        salario_bruto = (102 * horas_contratadas) + horas_extras * (102 + 102 * 0.23);
                    }

                    else
                    {
                        salario_bruto = (130 * horas_contratadas) + horas_extras * (130 + 130 * 0.23);
                    }
                }
            }
            
            else if (horas_extras > 13 && horas_extras <= 22) // 37%
            {
                if (funcao == 1)
                {
                    if (anos_experiencia <= 2)
                    {
                        salario_bruto = (25 * horas_contratadas) + horas_extras * (25 + 25 * 0.37);
                    }

                    else if (anos_experiencia >= 3 && anos_experiencia <= 5)
                    {
                        salario_bruto = (30 * horas_contratadas) + horas_extras * (30 + 30 * 0.37);
                    }

                    else
                    {
                        salario_bruto = (38 * horas_contratadas) + horas_extras * (38 + 38 * 0.37);
                    }
                }
                
                else if (funcao == 2)
                {
                    if (anos_experiencia <= 2)
                    {
                        salario_bruto = (45 * horas_contratadas) + horas_extras * (45 + 45 * 0.37);
                    }
                    
                    else if (anos_experiencia >= 3 && anos_experiencia <= 5)
                    {
                        salario_bruto = (55 * horas_contratadas) + horas_extras * (55 + 55 * 0.37);
                    }
                    
                    else
                    {
                        salario_bruto = (70 * horas_contratadas) + horas_extras * (70 + 70 * 0.37);
                    }
                }
                
                else if (funcao == 3)
                {
                    if (anos_experiencia <= 2)
                    {
                        salario_bruto = (85 * horas_contratadas) + horas_extras * (85 + 85 * 0.37);
                    }
                    
                    else if (anos_experiencia >= 3 && anos_experiencia <= 5)
                    {
                        salario_bruto = (102 * horas_contratadas) + horas_extras * (102 + 102 * 0.37);
                    }

                    else
                    {
                        salario_bruto = (130 * horas_contratadas) + horas_extras * (130 + 130 * 0.37);
                    }
                }
            }
            
            else if (horas_extras > 22) // %56
            {
                if (funcao == 1)
                {
                    if (anos_experiencia <= 2)
                    {
                        salario_bruto = (25 * horas_contratadas) + horas_extras * (25 + 25 * 0.56);
                    }
                    
                    else if (anos_experiencia >= 3 && anos_experiencia <= 5)
                    {
                        salario_bruto = (30 * horas_contratadas) + horas_extras * (30 + 30 * 0.56);
                    }
                    
                    else
                    {
                        salario_bruto = (38 * horas_contratadas) + horas_extras * (38 + 38 * 0.56);
                    }
                }

                else if (funcao == 2)
                {
                    if (anos_experiencia <= 2)
                    {
                        salario_bruto = (45 * horas_contratadas) + horas_extras * (45 + 45 * 0.56);
                    }
                    
                    else if (anos_experiencia >= 3 && anos_experiencia <= 5)
                    {
                        salario_bruto = (55 * horas_contratadas) + horas_extras * (55 + 55 * 0.56);
                    }
                    
                    else
                    {
                        salario_bruto = (70 * horas_contratadas) + horas_extras * (70 + 70 * 0.56);
                    }
                }
                
                else if (funcao == 3)
                {
                    if (anos_experiencia <= 2)
                    {
                        salario_bruto = (85 * horas_contratadas) + horas_extras * (85 + 85 * 0.56);
                    }

                    else if (anos_experiencia >= 3 && anos_experiencia <= 5)
                    {
                        salario_bruto = (102 * horas_contratadas) + horas_extras * (102 + 102 * 0.56);
                    }

                    else
                    {
                        salario_bruto = (130 * horas_contratadas) + horas_extras * (130 + 130 * 0.56);
                    }
                }
            }
        }

        if (salario_bruto <= 1500)
        {
            desconto_inss = salario_bruto * 0.11;
            salario_liquido = salario_bruto - desconto_inss;
            desconto_ir = 0;
        }

        else if (salario_bruto > 1500 && salario_bruto <= 2700)
        {
            desconto_inss = salario_bruto * 0.11;
            salario_pos_inss = salario_bruto - desconto_inss;
            desconto_ir = salario_pos_inss * 0.15;
            salario_liquido = salario_pos_inss - salario_pos_inss * 0.15;
        }
        
        else if (salario_bruto > 2700 && salario_bruto <= 4200)
        {
            desconto_inss = salario_bruto * 0.11;
            salario_pos_inss = salario_bruto - desconto_inss;
            desconto_ir = salario_pos_inss * 0.2;
            salario_liquido = salario_pos_inss - salario_pos_inss * 0.2;
        }
        
        else
        {
            desconto_inss = salario_bruto * 0.11;
            salario_pos_inss = salario_bruto - desconto_inss;
            desconto_ir = salario_pos_inss * 0.3;
            salario_liquido = salario_pos_inss - salario_pos_inss * 0.3;
        }

        printf("----RELATORIO DO FUNCIONARIO %d----:\n", i);
        printf("Salario bruto: R$ %.2f\n", salario_bruto);
        printf("Horas excedentes: %d\n", horas_extras);
        printf("Desconto INSS: R$ %.2f\n", desconto_inss);
        printf("Desconto IR: R$ %.2f\n", desconto_ir);
        printf("Salario liquido: R$ %.2f\n", salario_liquido);
    }
}