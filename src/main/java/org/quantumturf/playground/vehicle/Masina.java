package org.quantumturf.playground.vehicle;

public class Masina extends Vehicle {
    private String nume;
    private int nrUsi;
    private int treaptaViteza;

    public static boolean readyToDrive = true;

    public Masina() {

    }

    public Masina(int a){
        this.nrUsi = a;
    }

    public void porneste() {
        schimbareTreaptaViteza();
    }

    public void porneste(int a) {
        schimbareTreaptaViteza();
    }

    @Override
    public String porneste(int a, String b) {
        // super.porneste(2, "42");
        schimbareTreaptaViteza();
        return "a pornit Masina";
    }

    @Override
    public void deschide() {

    }

    public String porneste(String b, int a) {
        schimbareTreaptaViteza();
        return "a pornit Masina 2";
    }

    private void schimbareTreaptaViteza() {
        this.treaptaViteza = 1;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getNrUsi() {
        return nrUsi;
    }

    public void setNrUsi(int nrUsi) {
        this.nrUsi = nrUsi;
    }

    public class InnerClass {
        public static int nr;
    }
}
