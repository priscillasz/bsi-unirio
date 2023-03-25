package questao07;

import java.util.LinkedList;
import java.util.Scanner;

/* Imagine que você está criando um player de músicas e precise de uma funcionalidade que permita ao
usuário adicionar músicas em sequência, de forma que a primeira música adicionada será a primeira a ser tocada.
Qual estrutura de dados seria mais indicada para a implementação dessa funcionalidade?
Implemente esse algoritmo de forma simplificada. */

public class Q7 {

    public static class Musica {
        final private int duracao;
        final private String titulo;
        final private String artista;

        public Musica(int duracao, String titulo, String artista) {
            this.duracao = duracao;
            this.titulo = titulo;
            this.artista = artista;
        }

        public String toString() {
            return artista + " - " + titulo + " : " + duracao +"s";
        }

    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        LinkedList<Musica> lista = new LinkedList<>();
        lista.add(new Musica(240, "In Your Eyes", "The Weekend"));
        lista.add(new Musica(233, "Starboy", "The Weekend"));
        lista.add(new Musica(233, "Star Walkin", "Lil Nas X"));
        lista.add(new Musica(233, "Unholy", "Kim Petras & Sam Smith"));
        lista.add(new Musica(233, "Descontrolada", "Pabllo Vittar & MC Carol de Niterói"));
        lista.add(new Musica(233, "Idiota", "Jão"));
        lista.add(new Musica(233, "Phantom", "Rina Sawayama"));
        lista.add(new Musica(233, "ALIEN SUPERSTAR", "Beyoncé"));
        lista.add(new Musica(233, "Halo", "Beyoncé"));
        lista.add(new Musica(233, "Você me Perdeu", "Jão"));

        boolean vrf = true;
        int menu = -1;

        LinkedList<Musica> playlist = new LinkedList<>();

        while (vrf) {
            System.out.println("Escolha:\n1: ADICIONAR MUSICA \n2: TOCAR\n3: SAIR");
            menu = entrada.nextInt();

            switch(menu) {
                case 1:
                    for(int i = 0; i < lista.size(); i++) {
                        System.out.println(i + ": " + lista.get(i).toString());
                    }
                    int slc = entrada.nextInt();
                    while (slc < 0 || slc >=lista.size()) {
                        System.out.println("Incorreto!!! Escolha novamente:");
                        slc = entrada.nextInt();
                    }

                    playlist.add(lista.get(slc));
                    break;

                case 2:
                    System.out.println("Tocando... " + playlist.poll().toString()+"\n");

                    System.out.println("A seguir: \n");
                    for(int i = 0; i < playlist.size(); i++) {
                        System.out.println((i+1) + " :" + playlist.get(i).toString());
                    }
                    break;

                case 3:
                    vrf = false;
                    break;
            }
        }
    }
}
