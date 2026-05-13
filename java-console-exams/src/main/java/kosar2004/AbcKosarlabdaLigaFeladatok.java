package kosar2004;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class AbcKosarlabdaLigaFeladatok {
	// https://infojegyzet.hu/vizsgafeladatok/okj-programozas/szoftverfejleszto-200526/

	// puska: https://nagraggini.github.io/my-awesome-book/java.html

	// Példány szintű repository.
	private final IKosarlabdaRepository repository;

	// Példány szintű lista.
	private static ArrayList<AbcKosarlabdaLiga> lista = new ArrayList<>();

	public static Path utvonal = Path.of("java-console-exams/data/eredmenyek.csv");

	// Konstruktoron keresztül "befecskendezzük" a függőséget (Dependency
	// Injection).
	public AbcKosarlabdaLigaFeladatok(IKosarlabdaRepository repo) {
		this.repository = repo;
	}

	public void inditas() {
		// Itt használjuk az interfészt!
		// Mindegy, hogy a repo fájlból olvas, vagy mock adatot ad a lista feltöltődik.
		this.lista = repository.osszesMerkozesLekerese();

		if (getLista() == null || getLista().isEmpty()) {
			System.out.println("Nincs adat a feldolgozáshoz.");
			return;
		}

		// Kiiratas
		kiiratas();

		// 3. feladat
		hanyszorJatszottARealMadridOsszesen();
	}

	/**
	 * Az csv fájl teszteléséhez.
	 */
	public static ArrayList<AbcKosarlabdaLiga> getLista() {
		return lista;
	}

	public static void main(String[] args) {
		// 1. Létrehozzuk a konkrét megvalósítást (ami tényleg fájlból olvas)
		// Ehhez kell egy osztály, ami implementálja az IKosarlabdaRepository-t!
		IKosarlabdaRepository valodiRepo = new FajlKosarlabdaRepository(utvonal);

		// 2. "Beinjektáljuk" a megvalósítást
		AbcKosarlabdaLigaFeladatok program = new AbcKosarlabdaLigaFeladatok(valodiRepo);

		// 3. Elindítjuk.
		program.inditas();

		// System.out.println("Sorok száma: " + lista.size());

		// 4. feladat:
		// Megszámoljuk, hogy volt-e döntetlen.
		long dontetlen = getLista().stream(). // Adatfolyammá alakítás.
				filter(x -> x.getHazaiPont() == x.getIdegenPont()) // Szűrési feltétel.
				.count(); // Megszámoljuk.

		// A három operandust zárójelbe kell rakni. Ternális operátor.
		System.out.println("4. feladat: Volt-e döntetlen? " + ((int) dontetlen == 0 ? "nem" : "igen"));

		// 5. feladat:
		/*
		 * Határozza meg és írja ki a minta szerint, hogy a barcelonai csapatnak mi a
		 * pontos neve! (Feltételezheti, hogy a csapat neve tartalmazza Barcelona város
		 * nevét, és a csapat játszott otthon is legalább egy mérkőzést.)
		 */

		String barcelonaiCsapatNeve = getLista().stream().filter(x -> x.getHazai().contains("Barcelona"))
				.map(x -> x.getHazai()).findFirst().get();
		System.out.println("5. feladat: barcelonai csapat neve: " + barcelonaiCsapatNeve);

		// 6. feladat:
		/*
		 * Határozza meg és írja ki a minta szerint, hogy 2004. november 21-én mely
		 * csapatok játszottak mérkőzéseket, és milyen eredmény született!
		 */
		LocalDate datum = LocalDate.of(2004, 11, 21);

		System.out.println("6. feladat:");
		getLista().stream().filter(x -> x.getIdopont().isEqual(datum)).forEach(x -> System.out.println(
				"\t" + x.getHazai() + "-" + x.getIdegen() + " (" + x.getHazaiPont() + ":" + x.getIdegenPont() + ")"));

		// 7. feladat
		/*
		 * Határozza meg és írja ki a minta szerint, hogy melyek azok a stadionok,
		 * amelyek 20-nál több alkalommal voltak kosárlabdamérkőzések helyszínei! A
		 * stadionok neve mögött jelenjen meg a mérkőzések száma is! A feltételnek
		 * megfelelő stadionok tetszőleges sorrendben jelenhetnek meg.
		 */

		System.out.println("7. feladat: ");
		getLista().stream() // Az első stream az eredeti adatokat dolgozza fel.
				// Ez a "lelke" az egésznek. Egy Map<String, Long> struktúrát hoz létre, ahol a
				// kulcs a helyszín, az érték pedig az adott helyszínhez tartozó elemek száma.
				.collect(Collectors.groupingBy(AbcKosarlabdaLiga::getHelyszin, Collectors.counting()))
				// Mivel a Map-en nem tudunk közvetlenül streamelni, le kell kérnünk a
				// kulcs-érték párok halmazát (entrySet), majd abból indítunk egy új streamet.
				.entrySet().stream() // A második stream, már a statisztikát (a Map-et) dolgozza fel.
				.filter(e -> e.getValue() > 20) // Feltétel.
				.forEach(e -> System.out.println("\t" + e.getKey() + " : " + e.getValue())); // Kiíratás.
	}

	public static void kiiratas() {
		getLista().forEach(l -> System.out.println(l.toString()));
	}

	public static void hanyszorJatszottARealMadridOsszesen() {

		// 3. feladat:
		long realDBHazai = getLista().stream().filter(a -> a.getHazai().equals("Real Madrid")).count();

		long realDBIdegen = getLista().stream().filter(a -> a.getIdegen().equals("Real Madrid")).count();

		System.out.println("3. feladat: Real Madrid: Hazai: " + realDBHazai + ", Idegen: " + realDBIdegen);
	}

}
