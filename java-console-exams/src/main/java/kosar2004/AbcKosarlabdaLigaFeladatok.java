package kosar2004;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class AbcKosarlabdaLigaFeladatok {
	// https://infojegyzet.hu/vizsgafeladatok/okj-programozas/szoftverfejleszto-200526/

	// puska: https://nagraggini.github.io/my-awesome-book/java.html

	private IKosarlabdaRepository repository;

	// Példány szintű lista. Nincs static.
	private ArrayList<AbcKosarlabdaLiga> lista = new ArrayList<>();

	public static Path utvonal = Path.of("java-console-exams/data/eredmenyek.csv");

	// Konstruktoron keresztül "befecskendezzük" a függőséget (Dependency
	// Injection).
	public AbcKosarlabdaLigaFeladatok(IKosarlabdaRepository repo) {
		this.repository = repo; // Eltároljuk a befecskendezett függőséget
	}

	public void inditas() {
		// Itt használjuk az interfészt!
		// Mindegy, hogy a repo fájlból olvas, vagy mock adatot ad a lista feltöltődik.
		// A konstruktorban elmentett repository-tól kérjük le az adatokat
		ArrayList<AbcKosarlabdaLiga> eredmenyek = (ArrayList<AbcKosarlabdaLiga>) repository.osszesMerkozesLekerese();
		this.lista.clear();
		this.lista.addAll(eredmenyek);

		if (getLista().isEmpty()) {
			System.out.println("Nincs adat a feldolgozáshoz.");
			return;
		}

		// Kiiratas
		kiiratas();

		// 3. feladat
		hanyszorJatszottARealMadridOsszesen();

		hanyDontetlenVolt();
		otosFeladat();
		hatosFeladat();
		hetesFeladat();
	}

	/**
	 * Az csv fájl teszteléséhez.
	 */
	public ArrayList<AbcKosarlabdaLiga> getLista() {
		return lista;
	}

	public static void main(String[] args) {
		// 1. Létrehozzuk a konkrét megvalósítást (ami tényleg fájlból olvas)
		// Ehhez kell egy osztály, ami implementálja az IKosarlabdaRepository-t!
		IKosarlabdaRepository repository = new FajlKosarlabdaRepository(utvonal);

		// 2. "Beinjektáljuk" a megvalósítást
		AbcKosarlabdaLigaFeladatok program = new AbcKosarlabdaLigaFeladatok(repository);

		// 3. Elindítjuk.
		program.inditas();

		// System.out.println("Sorok száma: " + lista.size());
	}

	public void kiiratas() {
		this.getLista().forEach(l -> System.out.println(l.toString()));
	}

	public long hanyszorJatszottARealMadridOsszesen() {

		// 3. feladat:
		long realDBHazai = this.getLista().stream().filter(a -> a.getHazai().equals("Real Madrid")).count();

		long realDBIdegen = this.getLista().stream().filter(a -> a.getIdegen().equals("Real Madrid")).count();

		System.out.println("3. feladat: Real Madrid: Hazai: " + realDBHazai + ", Idegen: " + realDBIdegen);

		return realDBHazai + realDBIdegen;
	}

	public long hanyDontetlenVolt() {
		// 4. feladat:
		// Megszámoljuk, hogy volt-e döntetlen.
		long dontetlen = this.getLista().stream(). // Adatfolyammá alakítás.
				filter(x -> x.getHazaiPont() == x.getIdegenPont()) // Szűrési feltétel.
				.count(); // Megszámoljuk.

		// A három operandust zárójelbe kell rakni. Ternális operátor.
		System.out.println("4. feladat: Volt-e döntetlen? " + ((int) dontetlen == 0 ? "nem" : "igen"));
		return dontetlen;
	}

	public String otosFeladat() {
		// 5. feladat:
		/*
		 * Határozza meg és írja ki a minta szerint, hogy a barcelonai csapatnak mi a
		 * pontos neve! (Feltételezheti, hogy a csapat neve tartalmazza Barcelona város
		 * nevét, és a csapat játszott otthon is legalább egy mérkőzést.)
		 */

		String barcelonaiCsapatNeve = this.getLista().stream().filter(x -> x.getHazai().contains("Barcelona"))
				.map(x -> x.getHazai()).findFirst().orElse("Nincs találat");
		System.out.println("5. feladat: barcelonai csapat neve: " + barcelonaiCsapatNeve);
		return barcelonaiCsapatNeve;
	}

	public void hatosFeladat() {
		// 6. feladat:
		/*
		 * Határozza meg és írja ki a minta szerint, hogy 2004. november 21-én mely
		 * csapatok játszottak mérkőzéseket, és milyen eredmény született!
		 */
		LocalDate datum = LocalDate.of(2004, 11, 21);

		System.out.println("6. feladat:");
		this.getLista().stream().filter(x -> x.getIdopont().isEqual(datum)).forEach(x -> System.out.println(
				"\t" + x.getHazai() + "-" + x.getIdegen() + " (" + x.getHazaiPont() + ":" + x.getIdegenPont() + ")"));
	}

	public void hetesFeladat() {
		// 7. feladat
		/*
		 * Határozza meg és írja ki a minta szerint, hogy melyek azok a stadionok,
		 * amelyek 20-nál több alkalommal voltak kosárlabdamérkőzések helyszínei! A
		 * stadionok neve mögött jelenjen meg a mérkőzések száma is! A feltételnek
		 * megfelelő stadionok tetszőleges sorrendben jelenhetnek meg.
		 */

		System.out.println("7. feladat: ");
		this.getLista().stream() // Az első stream az eredeti adatokat dolgozza fel.
				// Ez a "lelke" az egésznek. Egy Map<String, Long> struktúrát hoz létre, ahol a
				// kulcs a helyszín, az érték pedig az adott helyszínhez tartozó elemek száma.
				.collect(Collectors.groupingBy(AbcKosarlabdaLiga::getHelyszin, Collectors.counting()))
				// Mivel a Map-en nem tudunk közvetlenül streamelni, le kell kérnünk a
				// kulcs-érték párok halmazát (entrySet), majd abból indítunk egy új streamet.
				.entrySet().stream() // A második stream, már a statisztikát (a Map-et) dolgozza fel.
				.filter(e -> e.getValue() > 20) // Feltétel.
				.forEach(e -> System.out.println("\t" + e.getKey() + " : " + e.getValue())); // Kiíratás.
	}

}