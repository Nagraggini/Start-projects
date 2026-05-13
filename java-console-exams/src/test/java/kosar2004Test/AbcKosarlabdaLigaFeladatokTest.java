package kosar2004Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;

import java.nio.file.Path;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import kosar2004.AbcKosarlabdaLigaFeladatok;
import kosar2004.FajlKosarlabdaRepository;
import kosar2004.IKosarlabdaRepository;

public class AbcKosarlabdaLigaFeladatokTest {

	private IKosarlabdaRepository mockRepo;
	private AbcKosarlabdaLigaFeladatok feladatok;

	// Valóságos és hamis metódus is egyszerre.
	private AbcKosarlabdaLigaFeladatok spyFeladatok;

	private Path utvonal = Path.of("java-console-exams/data/eredmenyek.csv");

	@BeforeEach // ctrl+shift+o az import fixálása
	void inicializalas() { // Minden teszt előtt lefut külön-külön.
		// 1. Létrehozzuk a mock adatforrást.
		mockRepo = new MockKosarlabdaRepository();

		// 2. Inicializáljuk a feladatokat végző osztályt a mock-al.
		// Így a feladatok osztál y ezentúl a mockRepo-tól kéri az adatokat, nem a csv
		// fájlból.
		feladatok = new AbcKosarlabdaLigaFeladatok(mockRepo);

		// Spy létrehozása valódi objektumon keresztül.
		// A Spy egy valódi, létező objektumot csomagol be.
		// TODO spy használata.
		spyFeladatok = spy(new AbcKosarlabdaLigaFeladatok(mockRepo));

	}

	@AfterEach
	void reseteles() { // Minden teszt után lefut külön-külön.

	}

	@Test
	@DisplayName("Lista feltöltése csv fájlból.")
	void listaFeltolteseTest() {
		// 1. Létrehozzuk a konkrét megvalósítást (ami tényleg fájlból olvas)
		// Ehhez kell egy osztály, ami implementálja az IKosarlabdaRepository-t!
		IKosarlabdaRepository valodiRepo = new FajlKosarlabdaRepository(utvonal);

		// 2. "Beinjektáljuk" a megvalósítást
		AbcKosarlabdaLigaFeladatok program = new AbcKosarlabdaLigaFeladatok(valodiRepo);

		// 3. Elindítjuk.
		program.inditas();

		// Ellenőrizzük, hogy a lista nem maradt-e üres
		assertTrue(AbcKosarlabdaLigaFeladatok.getLista().size() > 0,
				"A listának tartalmaznia kell adatokat a beolvasás után!");
	}

	@Test
	@DisplayName("Lista feltöltése csv fájlból negatív teszt.")
	void listaFeltolteseNegativTest() {
		Path hibasUtvonal = Path.of("eredmenyek.csv");

		// 1. Létrehozzuk a konkrét megvalósítást (ami tényleg fájlból olvas)
		// Ehhez kell egy osztály, ami implementálja az IKosarlabdaRepository-t!
		IKosarlabdaRepository valodiRepo = new FajlKosarlabdaRepository(hibasUtvonal);

		// 2. "Beinjektáljuk" a megvalósítást
		AbcKosarlabdaLigaFeladatok program = new AbcKosarlabdaLigaFeladatok(valodiRepo);

		// 3. Elindítjuk és ellenőrizzük a hibadobást.
		assertThrows(NullPointerException.class, () -> program.inditas());
	}

}