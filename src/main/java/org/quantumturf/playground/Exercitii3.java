package org.quantumturf.playground;

import java.util.Scanner;

public class Exercitii3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti primul numar : ");
         int numar1 =scanner.nextInt();
        System.out.println("Introduceti al doilea  numar : ");
        int numar2 =scanner.nextInt();
         double impartire = impartireDouaNumere(numar1,numar2);
        System.out.println("Rezultatul impartirii este : " + impartire);
    }
    public static double impartireDouaNumere(int numar1 , int numar2){
        return numar1 / (double) numar2 ;
    }

}