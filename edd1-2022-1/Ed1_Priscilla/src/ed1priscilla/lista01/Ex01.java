package ed1priscilla.lista01;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // leitura das notas
        // Física
        System.out.println("Insira as notas de Física:");
        double prova1Fis;
        do {
            System.out.println("Nota da prova 1:");
            prova1Fis = scanner.nextDouble();
        } while(prova1Fis < 0 || prova1Fis > 10);

        double prova2Fis;
        do {
            System.out.println("Nota da prova 2:");
            prova2Fis = scanner.nextDouble();
        } while(prova2Fis < 0 || prova2Fis > 10);

        double trab1Fis;
        do {
            System.out.println("Nota do trabalho 1:");
            trab1Fis = scanner.nextDouble();
        } while (trab1Fis < 0 || trab1Fis > 10);

        Fisica fisica = new Fisica(prova1Fis, prova2Fis, trab1Fis);

        // Português
        System.out.println("Insira as notas de Português:");
        double prova1Port;
        do {
            System.out.println("Nota da prova 1:");
            prova1Port = scanner.nextDouble();
        } while(prova1Port < 0 || prova1Port > 10);

        double prova2Port;
        do {
            System.out.println("Nota da prova 2:");
            prova2Port = scanner.nextDouble();
        } while(prova2Port < 0 || prova2Port > 10);

        double trab1Port;
        do {
            System.out.println("Nota do trabalho 1:");
            trab1Port = scanner.nextDouble();
        } while (trab1Port < 0 || trab1Fis > 10);

        Portugues portugues = new Portugues(prova1Port, prova2Port, trab1Port);

        // Matemática
        System.out.println("Insira as notas de Matemática:");
        double prova1Mat;
        do {
            System.out.println("Nota da prova 1:");
            prova1Mat = scanner.nextDouble();
        } while(prova1Mat < 0 || prova1Mat > 10);

        double prova2Mat;
        do {
            System.out.println("Nota da prova 2:");
            prova2Mat = scanner.nextDouble();
        } while(prova2Mat < 0 || prova2Mat > 10);

        double trab1Mat;
        do {
            System.out.println("Nota do trabalho 1:");
            trab1Mat = scanner.nextDouble();
        } while(trab1Mat < 0 || trab1Mat > 10);

        Matematica matematica = new Matematica(prova1Mat, prova2Mat, trab1Mat);

        // cálculo das notas
        fisica.calcularMedia();
        portugues.calcularMedia();
        matematica.calcularMedia();

        // Impressão das médias
        System.out.println("Média de Física: " + fisica.getMedia());
        System.out.println("Média de Português: " + portugues.getMedia());
        System.out.println("Média de Matemática: " + matematica.getMedia());
    }
}
