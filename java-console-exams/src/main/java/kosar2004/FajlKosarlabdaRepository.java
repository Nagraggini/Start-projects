package kosar2004;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Ez az osztály tartalmazza a fájlbeolvasó logikát.
 */
public class FajlKosarlabdaRepository implements IKosarlabdaRepository {

	private Path fajlutvonal;
	ArrayList<AbcKosarlabdaLiga> lista;

	// Konstruktor.
	public FajlKosarlabdaRepository(Path fajlutvonal) {
		this.fajlutvonal = fajlutvonal;
	}

	@Override
	public ArrayList<AbcKosarlabdaLiga> osszesMerkozesLekerese() {
		// 2. feladat:
		// Van amikor ez a jó: StandardCharsets.UTF_8
		// Van amikor ez a jó:Charset.forName("windows-1250")

		// Ellenőrzés és beolvasás egyben
		if (!Files.exists(fajlutvonal)) {
			System.out.println("Nem létezik a fájl!");
			System.out.println("Itt keresem: " + System.getProperty("user.dir"));

			throw new IllegalArgumentException("Nem találom a fájlt");
			// return; // Ha nincs fájl, ne is menjünk tovább a try-ra, ez akkor jön jól, ha
			// nincs throw
		}

		lista = new ArrayList<>();

		try {
			List<String> sorok = Files.readAllLines(fajlutvonal, Charset.forName("windows-1250"));

			// 1-től megyünk, mert van oszlopnév is.
			for (int i = 1; i < sorok.size(); i++) {
				String[] t = sorok.get(i).split(";");

				lista.add(new AbcKosarlabdaLiga(t[0], t[1], Integer.parseInt(t[2]), Integer.parseInt(t[3]), t[4],
						LocalDate.parse(t[5])));

			}
		} catch (IOException ex) {
			System.getLogger(AbcKosarlabdaLiga.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
		}

		return lista;
	}

	@Override
	public void setLista(int index, AbcKosarlabdaLiga liga) {
		lista.set(index, liga);

	}

}
