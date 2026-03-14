package vizibicikliKolcsonzo;

//Nev;JAzon;EOra;EPerc;VOra;Vperc
public class Kolcsonzes {

    // Adattagok
    private String nev;
    private String jAzon;
    private int eOra;
    private int ePerc;
    private int vOra;
    private int vPerc;

    // jobb klikk -> Source Action -> Create getter and setter
    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    // 7 db jármű van.
    public String getjAzon() {
        return jAzon;
    }

    public int geteOra() {
        return eOra;
    }

    public void seteOra(int eOra) {
        this.eOra = eOra;
    }

    public int getePerc() {
        return ePerc;
    }

    public void setePerc(int ePerc) {
        this.ePerc = ePerc;
    }

    public int getvOra() {
        return vOra;
    }

    public void setvOra(int vOra) {
        this.vOra = vOra;
    }

    public int getvPerc() {
        return vPerc;
    }

    public void setvPerc(int vPerc) {
        this.vPerc = vPerc;
    }

    // Konstruktor
    public Kolcsonzes(String nev, String jAzon, int eOra, int ePerc, int vOra, int vPerc) {
        this.nev = nev;
        this.jAzon = jAzon;
        this.eOra = eOra;
        this.ePerc = ePerc;
        this.vOra = vOra;
        this.vPerc = vPerc;
    }

    public Kolcsonzes() {
    }

    @Override
    public String toString() {
        return String.format(
                "Kölcsönző neve: %s, jármű azonosítója: %s, elvitel ideje: %02d:%02d, visszahozás ideje: %02d:%02d",
                nev, jAzon, eOra, ePerc, vOra, vPerc);
    }
}
