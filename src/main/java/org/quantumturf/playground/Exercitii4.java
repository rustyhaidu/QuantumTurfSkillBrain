package org.quantumturf.playground;

import java.util.Random;
import java.util.Scanner;

public class Exercitii4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti primul numar : ");
        int numar1 = scanner.nextInt();
       String estePersoanaMinoraSauMajora = estePersoanaMinoraSauMajora(numar1);
        System.out.println(estePersoanaMinoraSauMajora);
    }
    public static String estePersoanaMinoraSauMajora(int numar1){
        if(numar1>18){
            return ("Persoana este majora : ");
        }else{
            return ("Persoana este  minora: ");
        }
    }
    public static String returnRockPaperScissors(){
        Random random = new Random();
        int numar = random.nextInt(3);
        return switch (numar) {
            case 0 -> "Rock";
            case 1 -> "Paper";
            default  -> "Scissors";
        };
    }
}