package org.quantumturf.playground;

import java.util.Scanner;

public class Exercitii2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti un numar de la tastura :");
        int numar= scanner.nextInt();
        System.out.println("Numarul este : " + numar);
        boolean esteDivizibilCu3 = numarDivizibilCu3(numar);
        boolean esteNumarParSauImpar = numarParSauImpar(numar);
        int inmultireDouaNumere = inmultireDouaNumere(numar,numar);
        System.out.println("Rezultatul inmultirii : " + inmultireDouaNumere);
        if(esteDivizibilCu3 ){
            System.out.println("Numarul introdus de la tastatura este divizbil cu 3 : " + numar);
        }else{
            System.out.println("Numarul introdus de la tastatura nu este divizbil cu 3 : " + numar);
        }
        if(esteNumarParSauImpar){
            System.out.println("Este numar par : " + numar);
        }else{
            System.out.println("Nu este un numar par : " + numar);
        }
    }
    public static boolean numarDivizibilCu3(int numar) {
          return numar % 3 == 0;
    }
    public static boolean numarParSauImpar(int numar){
        return numar % 2 ==0;
    }
    public static int  inmultireDouaNumere(int numar1 , int numar2){
        return numar1 * numar2;
    }
}
