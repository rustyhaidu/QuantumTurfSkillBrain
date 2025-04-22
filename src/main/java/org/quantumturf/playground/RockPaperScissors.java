package org.quantumturf.playground;

import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti Rock , Paper sau Scissors : ");
        String text = scanner.nextLine();
        String answerRobot = Exercitii4.returnRockPaperScissors();
        if(text.equals(answerRobot)){
            System.out.println("Egalitate ");
        } else if (text.equals("Rock")){
            switch (answerRobot){
                case "Scissors":
                    System.out.println("Ai castigat ");
                    break;
                default:
                    System.out.println("Ai pierdut ");
            }

        } else if (text.equals("Paper")) {
            switch (answerRobot){
                case "Scissors":
                    System.out.println("Ai pierdut ");
                    break;
                default:
                    System.out.println("Ai castigat ");
            }
        } else if (text.equals("Scissors")) {
            switch (answerRobot){
                case "Rock ":
                    System.out.println("Ai pierdut ");
                    break;
                default:
                    System.out.println("Ai castigat ");
            }
        }
    }
}
