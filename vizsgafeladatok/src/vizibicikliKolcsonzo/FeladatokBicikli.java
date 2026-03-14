package vizibicikliKolcsonzo;

import java.util.*;

public class FeladatokBicikli {

    public Scanner sc = new Scanner(System.in);

    public ArrayList kiListazas(ArrayList<Kolcsonzes> lista) {

        // Bejáros for-each-s kiíratás
        for (Kolcsonzes egyKolcson : lista) {
            // System.out.println(egyKolcson.getNev() + " - " + egyKolcson.getjAzon());
            System.out.println(egyKolcson.toString());
        }

        sc.close();

        return lista;
    }

    public ArrayList keresesNevAlapjan(ArrayList<Kolcsonzes> lista) {

        System.out.print("6. feladat: Kérek egy nevet: ");
        String keresettNev = sc.next();

        System.out.println(keresettNev + " kölcsönzései: ");

        boolean benneVanaAKeresettNev = false;

        for (Kolcsonzes kolcsonzes : lista) {
            // Kell, hogy pontosan melyik mezőt hasonlítjuk össze.
            if (kolcsonzes.getNev().contains(keresettNev)) {
                // kiírás
                System.out.println(kolcsonzes.toString());

                benneVanaAKeresettNev = true;
            }

        }

        if (benneVanaAKeresettNev == false) {
            System.out.println("Nem volt ilyen nevű kölcsönző!");
        }

        sc.close();
        return lista;
    }

    public ArrayList idopontAlapjanTortenoKilistazas(ArrayList<Kolcsonzes> lista) {

        // Majd ki kell egészíteni az órát és a percet 0-vel, ha egy számjegyű lenne.
        System.out.print("7. Feladat: Adjon meg egy időpontot óra:perc alakban: ");
        String keresettIdopont = sc.next(); // pl.: 12:50

        // Feltételezhetjük a feladat szerint, hogy legalább egy jármű volt a vizen.
        String[] idopont = keresettIdopont.split(":");

        int keresettOra = Integer.parseInt(idopont[0]);
        int keresettPerc = Integer.parseInt(idopont[1]);

        // Átalakítás percre:
        int keresettOsszPerc = keresettOra * 60 + keresettPerc;

        System.out.println("A vízen lévő járművek: ");

        for (Kolcsonzes kolcsonzes : lista) {

            int kezdesPerc = kolcsonzes.geteOra() * 60 + kolcsonzes.getePerc();
            int vegPerc = kolcsonzes.getvOra() * 60 + kolcsonzes.getvPerc();

            if (kezdesPerc <= keresettOsszPerc && keresettOsszPerc < vegPerc) {

                System.out.println(String.format("%02d:%02d-%02d:%02d : %s", kolcsonzes.geteOra(),
                        kolcsonzes.getePerc(), kolcsonzes.getvOra(), kolcsonzes.getvPerc(), kolcsonzes.getNev()));
                // %02d -> Ha rövidebb feltölti 0-val balról.
            }

        }

        sc.close();
        return lista;
    }

    public ArrayList napiBevetel(ArrayList<Kolcsonzes> lista) {
        /* Minden megkezdett 30 perc egységesen 2400 Ft. A napi bevételt írd ki. */

        int hanyDbMegkezdettFelOra = 0;

        for (Kolcsonzes kolcsonzes : lista) {
            int eOsszPerc = kolcsonzes.geteOra() * 60 + kolcsonzes.getePerc();
            int vOsszPerc = kolcsonzes.getvOra() * 60 + kolcsonzes.getvPerc();
            int osszPerc = vOsszPerc - eOsszPerc;

            // Lebegőpontos osztást kell csinálni:
            hanyDbMegkezdettFelOra += (int) Math.ceil(osszPerc / 30.0);// Felfelé kerekítünk.

        }

        System.out.println("8. feladat: A napi bevétel: " + hanyDbMegkezdettFelOra * 2400 + " Ft");
        return lista;
    }

    public ArrayList jarmuRongalas(ArrayList<Kolcsonzes> lista, String jAzon) {

        // Hozz létre egy F.txt-t ami tartalmazza a lehetséges elkövetőket és azt, hogy
        // metől meddig volt náluk a jármű.
        // Minta: 10:15-10:55 : Bence
        ArrayList<String> lehetsegesElkovetok = new ArrayList<>();

        for (Kolcsonzes kolcsonzes : lista) {

            if (kolcsonzes.getjAzon().equals(jAzon)) {

                String gyanusitott = String.format("%02d:%02d-%02d:%02d : %s", kolcsonzes.geteOra(),
                        kolcsonzes.getePerc(), kolcsonzes.getvOra(), kolcsonzes.getvPerc(), kolcsonzes.getNev());

                lehetsegesElkovetok.add(gyanusitott);
            }

        }

        // Fájlba kiíratás.

        return lehetsegesElkovetok;
    }

    public HashMap<String, Integer> statisztika(ArrayList<Kolcsonzes> lista) {

        // key és value
        HashMap<String, Integer> stat = new HashMap<>();

        // 7 db jármű.
        stat.put("A", 0);
        stat.put("B", 0);
        stat.put("C", 0);
        stat.put("D", 0);
        stat.put("E", 0);
        stat.put("F", 0);
        stat.put("G", 0);

        // Végig megyünk a listán.
        for (Kolcsonzes egyKolcson : lista) {

            // Lekérjük egy jármű azonosítóját.
            String jAzon = egyKolcson.getjAzon();

            // Lecsekkoljuk, hogy tartalmazza-e.
            if (stat.containsKey(jAzon)) {
                // put-al hozzáadjuk a megadott azonosítóhoz, get-el lekérjük a value-t.
                // stat.containsValue(0); -> A key-t kérjük le.
                stat.put(jAzon, stat.get(jAzon) + 1);
            }
        }

        // Rendezés abc szerint.
        Map<String, Integer> rendezettStat = new TreeMap<>(stat);

        // Kiíratás
        System.out.println("10. feladat: Statisztika:");
        for (String key : rendezettStat.keySet()) {
            System.out.println(key + " - " + rendezettStat.get(key));
        }

        return stat;
    }
}
