package org.quantumturf.playground;

import org.quantumturf.playground.vehicle.Masina;
import org.quantumturf.playground.vehicle.Vehicle;

public class Main3 {
    public static void main(String[] args) {
        Vehicle masina1 = new Masina("FADAD1");
        Vehicle masina2 = new Masina("FADAD1");

        ((Masina) masina2).setNume("BMW");

        boolean rez = masina1.equals(masina2);
        if (rez) {
            System.out.println("Sunt egale");
        } else {
            System.out.println("Nu sunt egale");
        }
    }
}
