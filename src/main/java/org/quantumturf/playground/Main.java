package org.quantumturf.playground;

import org.quantumturf.playground.vehicle.Masina;
import org.quantumturf.playground.vehicle.MyMethods;
import org.quantumturf.playground.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Masina masina1 = new Masina();


        Masina    masina2 = new
        Masina();

        Vehicle vehicle = new Vehicle() {
            @Override
            public void deschide() {
                System.out.println();
            }
        };

        masina1.setNume("Audi");
        masina1.setNrUsi(4);

        Masina masina3 = new Masina();
        masina1.setNume("BMW");
        masina1.setNrUsi(2);

        // System.out.println(masina1.getNume());
        masina1.porneste();
        masina1.porneste(1);
        // System.out.println(masina1.porneste(3, "string"));

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle);
        vehicles.add(masina1);

        for (Vehicle vehicle1 : vehicles) {
            System.out.println(vehicle1.porneste(4, "abc"));
        }

        boolean isReady = Masina.readyToDrive;

        Masina.readyToDrive = true;
        Masina.readyToDrive = false;
        Masina.readyToDrive = true;

        System.out.println(Masina.readyToDrive); // true
        System.out.println(Masina.readyToDrive); // true
        System.out.println(Masina.readyToDrive); // true

        String nr = "42";
        int numar = Integer.parseInt(nr);
        System.out.println(numar);

        String value = String.valueOf(numar);
        System.out.println(value);

        Masina.InnerClass.nr = 5;
    }


}
