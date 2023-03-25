package questao05;

import java.util.*;

/* As estruturas de dados estão presentes em diversas funcionalidades simples que usamos .
Por exemplo, a mecânica de voltar e avançar nos navegadores pode ser representada, de forma simplificada, por uma pilha.
Sabendo disso, escreva um algoritmo simples de avançar/voltar utilizando pilha. */

public class Q5 {
    public static void imprime (Stack<String> pilha) {
        System.out.print("PILHA:\n| ");

        for(int i = 0; i < pilha.size(); i++){
            System.out.print(pilha.get(i) + " | ");
        }
        System.out.print("\n");
    }


    public static void main (String args[]) {
        Scanner entrada = new Scanner(System.in);
        Stack<String> pilha = new Stack<String>();

        int menu = -1;
        int pagina = 1;

        while(pagina >= 1) {
            System.out.println("MENU:\n1: PRÓXIMA PÁGINA - 2: VOLTAR - 3: IMPRIMIR PILHA - 4: SAIR");
            menu = entrada.nextInt();

            switch(menu) {
                case 1:
                    pilha.push("Página " + pagina);
                    pagina++;
                    break;
                case 2:
                    pilha.pop();
                    pagina--;
                    break;
                case 3:
                    imprime(pilha);
                    break;
                case 4:
                    pagina = 0;
                    break;
                default:
                    System.out.println("Opção incorreta!\n");
                    break;
            }
        }
        entrada.close();
    }
}