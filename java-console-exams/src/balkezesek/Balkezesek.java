package balkezesek;

import java.time.LocalDate;

public class Balkezesek {

    // Adattagok
    private String nev;
    private LocalDate elso;
    private LocalDate utolso;
    private int suly; // fontban
    private int magassag; // inch-ben
    
    //Konstruktor
    public Balkezesek(String nev, LocalDate elso, LocalDate utolso, int suly, int magassag) {
        this.nev = nev;
        this.elso = elso;
        this.utolso = utolso;
        this.suly = suly;
        this.magassag = magassag;
    }

    //Getterek
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

    
}
