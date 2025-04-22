package org.quantumturf.playground.vehicle;

import java.util.Objects;

public class Masina extends Vehicle {
    private String nume;
    private int nrUsi;
    private int treaptaViteza;
    private String serieSasiu;

    public static boolean readyToDrive = true;

    public Masina() {

    }

    public Masina(String serieSasiu) {
        this.serieSasiu = serieSasiu;
    }

    public Masina(int a) {
        this.nrUsi = a;
    }

    public int getTreaptaViteza() {
        return treaptaViteza;
    }

    public void setTreaptaViteza(int treaptaViteza) {
        this.treaptaViteza = treaptaViteza;
    }

    public static boolean isReadyToDrive() {
        return readyToDrive;
    }

    public static void setReadyToDrive(boolean readyToDrive) {
        Masina.readyToDrive = readyToDrive;
    }

    public String getSerieSasiu() {
        return serieSasiu;
    }

    public void setSerieSasiu(String serieSasiu) {
        this.serieSasiu = serieSasiu;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Masina masina = (Masina) o;
        return Objects.equals(serieSasiu, masina.serieSasiu);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(serieSasiu);
    }
}
