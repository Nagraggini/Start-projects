package kosar2004Gyakorlas;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static java.util.stream.Collectors.groupingBy;

public class KosarligaGyakorlas {

    // https://infojegyzet.hu/vizsgafeladatok/okj-programozas/szoftverfejleszto-200526/

    // Puska: https://github.com/Nagraggini/blog/blob/main/Java_basic_knowledge.md

    public static ArrayList<AbcKosarlabdaLiga> lista = new ArrayList<>();
    public static HashMap<Integer, AbcKosarlabdaLiga> hmap = new HashMap<>();

    public static void main(String[] args) {

        Fajlbeolvasasa("java-console-exams/eredmenyek.csv");

        System.out.println("Sorok száma: " + lista.size());
        nagyFolennyelNyertek(lista, 3);
    }

    public static void Fajlbeolvasasa(String fajlneve) {

        // 2. feladat:
        // Van amikor ez a jó: StandardCharsets.UTF_8
        // Van amikor ez a jó:Charset.forName("windows-1250")

        Path path = Path.of(fajlneve);

        // Ellenőrzés és beolvasás egyben
        if (!Files.exists(path)) {
            System.out.println("Nem létezik a fájl!");
            System.out.println("Itt keresem: " + System.getProperty("user.dir"));
            return; // Ha nincs fájl, ne is menjünk tovább a try-ra
        }

        try {
            List<String> sorok = Files.readAllLines(path, Charset.forName("windows-1250"));

            // 1-től megyünk, mert van oszlopnév is.
            for (int i = 1; i < sorok.size(); i++) {
                String[] t = sorok.get(i).split(";");

                lista.add(new AbcKosarlabdaLiga(t[0], t[1], Integer.parseInt(t[2]), Integer.parseInt(t[3]), t[4],
                        LocalDate.parse(t[5])));
            }
        } catch (IOException ex) {
            System.getLogger(AbcKosarlabdaLiga.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public static void kiiratasArrayList(ArrayList<AbcKosarlabdaLiga> lista) {

        lista.forEach(l -> System.out.println(l.toString()));

        // A stream ilyen esetben felesleges, mert nincs filter, vagy map.
        // lista.stream().forEach(x -> System.out.println(x.getHelyszin()));

    }

    public static void kiiratasHashMap(HashMap<Integer, AbcKosarlabdaLiga> hmap) {
        // foreach+lambda
        hmap.forEach((kulcs, ertek) -> {
            System.out.println("Kulcs: " + kulcs + " érték: " + ertek);

        });

        // Egy elem kiirasa.
        // 0. vagy 1. elemet írja ki ez attól függ, hogy van-e fejléc.
        System.out.println("Első elem: " + (hmap.get(0) == null ? hmap.get(1) : hmap.get(0)));
        System.out.println("Utolsó elem: " + hmap.get(hmap.size()));

    }

    public static void melyikVarosbanHanyMeccsVolt(ArrayList<AbcKosarlabdaLiga> lista) {

        // Első megoldás.
        System.out.println("\nMegoldás ArrayList+HashMap-el.");
        HashMap<String, Integer> stat = new HashMap<>();

        // Megszámoljuk, hogy melyik városban hányszor volt meccs.
        for (AbcKosarlabdaLiga a : lista) {
            stat.put(a.getHelyszin(), stat.getOrDefault(a.getHelyszin(), 0) + 1);
        }

        stat.forEach((kulcs, ertek) -> System.out.println("Kulcs: " + kulcs + " érték: " + ertek));

        // Második szebbik megoldás stream apival.
        lista.stream().collect(groupingBy(AbcKosarlabdaLiga::getHelyszin, java.util.stream.Collectors // Csoportosítunk
                                                                                                      // helyszín
                                                                                                      // alapján.
                .counting())) // Megszámoljuk.
                .forEach((varos, db) -> System.out.println(varos + " : " + db + " meccs.")); // Kiiratás.

    }

    public static void nagyFolennyelNyertek(ArrayList<AbcKosarlabdaLiga> lista, int kulonbseg) {

        // A pontszámok közti különbség alapján szűrünk és megszámoljuk hány db ilyen
        // meccs volt.
        System.out.println(lista.stream()
                // Csak azokat hagyjuk meg, ahol a különbség pontosan ennyi
                .filter(l -> Math.abs(l.getIdegenPont() - l.getHazaiPont()) == kulonbseg)
                // Megszámoljuk hány ilyen meccs volt.
                .count() + " db olyan meccs volt, amiknél a pont különbség " + kulonbseg + " pont volt.");
    }

    public static void realMadridMeccsek(ArrayList<AbcKosarlabdaLiga> lista) {

        // Real Madrid hány mérkőzést játszott hazai és idegen csapatként. Külön-külön
        // írd ki.

        // Egyik megoldás foreach+lamda.
        int[] realDB = { 0, 0 };

        lista.forEach(a -> {
            if (a.getHazai().equals("Real Madrid")) {
                realDB[0]++;
            } else if (a.getIdegen().equals("Real Madrid")) {
                realDB[1]++;
            }

        });

        // Másik megoldás stream api+lambda.
        long hazaiMeccsek = lista.stream()
                .filter(a -> a.getHazai().equals("Real Madrid"))
                .count();

        long idegenMeccsek = lista.stream()
                .filter(a -> a.getIdegen().equals("Real Madrid"))
                .count();

        System.out.println("3. feladat: Real Madrid: Hazai: " + hazaiMeccsek + ", Idegen: " + idegenMeccsek);

    }

    public static void voltEDontetlen(ArrayList<AbcKosarlabdaLiga> lista) {

        // Megszámoljuk, hogy volt-e döntetlen.
        long dontetlen = lista.stream(). // Adatfolyammá alakítás.
                filter(x -> x.getHazaiPont() == x.getIdegenPont()) // Szűrési feltétel.
                .count(); // Megszámoljuk.

        // A három operandust zárójelbe kell rakni. Ternális operátor.
        System.out.println("4. feladat: Volt-e döntetlen? " + ((int) dontetlen == 0 ? "nem" : "igen"));

    }

    /*
     * TODO
     * Könnyű feladatok
     * 
     * Hazai győzelmek
     * Listázd ki az összes meccset, ahol a hazai csapat nyert (hazai_pont >
     * idegen_pont).
     * 
     * Real Madrid meccsek
     * Szűrd ki az összes meccset, ahol a Real Madrid játszott hazai vagy idegen
     * csapatként.
     * 
     * Hazai csapatok nevei
     * Hozz létre egy egyszerű listát az összes hazai csapat nevével, ismétlődés
     * nélkül.
     * 
     * Közepes feladatok
     * 
     * Átlagos hazai pont
     * Számold ki az átlagos pontszámot, amit a hazai csapatok szereztek az összes
     * meccsen.
     * 
     * Top 3 leggyőztes hazai csapat
     * Találd meg a 3 legtöbbször nyerő hazai csapatot. (Hazai győzelem = hazai_pont
     * > idegen_pont)
     * 
     * Pontkülönbség nagyobb mint 10
     * Listázd ki azokat a meccseket, ahol a győztes legalább 10 ponttal nyert.
     * 
     * Összes pont csapatokra bontva
     * Készíts egy Map<String, Integer>-t, ahol minden csapat nevehez az összes
     * szerzett pont van hozzáadva (hazai és idegen meccsek együtt).
     * 
     * Nehéz feladatok
     * 
     * Legjobb helyszín
     * Találd meg azt a helyszínt, ahol a legtöbb meccset játszották.
     * 
     * Legtöbb győzelmet szerző csapat
     * Számold meg melyik csapat nyerte a legtöbb meccset (hazai + idegen győzelmek
     * együtt).
     * 
     * Top 3 legmagasabb pontszámú meccs
     * Találd meg a 3 meccset a legmagasabb összpontszámmal (hazai_pont +
     * idegen_pont), és rendezd csökkenő sorrendbe.
     */

}
