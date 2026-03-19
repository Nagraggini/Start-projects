package balkezesek;

import java.time.LocalDate;

public class Balkezesek {

    // Adattagok
    private String nev;
    private LocalDate elso;
    private LocalDate utolso;
    private int suly; // fontban
    private int magassag; // inch-ben

    // Konstruktor
    public Balkezesek(String nev, LocalDate elso, LocalDate utolso, int suly, int magassag) {
        this.nev = nev;
        this.elso = elso;
        this.utolso = utolso;
        this.suly = suly;
        this.magassag = magassag;
    }

    // Getterek
    public String getNev() {
        return nev;
    }

    public LocalDate getElso() {
        return elso;
    }

    public LocalDate getUtolso() {
        return utolso;
    }

    public int getSuly() {
        return suly;
    }

    public int getMagassag() {
        return magassag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Balkezesek{");
        sb.append("nev=").append(nev);
        sb.append(", elso=").append(elso);
        sb.append(", utolso=").append(utolso);
        sb.append(", suly=").append(suly);
        sb.append(", magassag=").append(magassag);
        sb.append('}');
        return sb.toString();
    }

}
