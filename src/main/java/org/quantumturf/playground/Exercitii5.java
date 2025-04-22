package org.quantumturf.playground;

import java.util.Scanner;

public class Exercitii5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introducdeti textul : ");
        String text = scanner.nextLine();
        int lungime = lungimeaTextului(text);
        System.out.println("Lungimea textului este de : " + lungime);

    }
    public static int  lungimeaTextului(String text){
        return text.length();
    }
}