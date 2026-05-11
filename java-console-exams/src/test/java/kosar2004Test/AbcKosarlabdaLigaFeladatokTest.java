package test.java.kosar2004Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.java.kosar2004.AbcKosarlabdaLiga;
import main.java.kosar2004.AbcKosarlabdaLigaFeladatok;

public class AbcKosarlabdaLigaFeladatokTest {

	AbcKosarlabdaLiga abckosarlabdaObj;
	AbcKosarlabdaLigaFeladatok abckosarlabdafeladatokObj;

	@BeforeEach // ctrl+shift+o az import fixálása
	void inicializalas() { // Minden teszt előtt lefut külön-külön.
		LocalDate idopont = LocalDate.now().minusMonths(1);

		abckosarlabdaObj = new AbcKosarlabdaLiga("7up", "6down", 81, 73, "Barcelona", idopont);

		AbcKosarlabdaLiga realMadridMeccs = new AbcKosarlabdaLiga("Real Madrid", "Barcelona", 88, 85, "Madrid",
				LocalDate.of(2024, 5, 10));
		AbcKosarlabdaLiga kiutesesMeccs = new AbcKosarlabdaLiga("Lakers", "Real Madrid", 120, 92, "Los Angeles",
				LocalDate.of(2024, 5, 11));
		AbcKosarlabdaLiga vedekezoMeccs = new AbcKosarlabdaLiga("Olympiacos", "Fenerbahce", 62, 58, "Piraeus",
				LocalDate.now().minusDays(3));
		AbcKosarlabdaLiga magyarMeccs = new AbcKosarlabdaLiga("Falco KC", "Alba Fehérvár", 94, 82, "Szombathely",
				LocalDate.now().minusWeeks(2));
		AbcKosarlabdaLiga vendegGyozelem = new AbcKosarlabdaLiga("Bulls", "Celtics", 101, 115, "Chicago",
				LocalDate.of(2024, 4, 20));
		
		//TODO
		abckosarlabdafeladatokObj.lista .add(abckosarlabdaObj);
		abckosarlabdafeladatokObj = new AbcKosarlabdaLigaFeladatok();
	}

	@AfterEach
	void reseteles() {
		abckosarlabdafeladatokObj.lista = null;
	}

	@Test
	@DisplayName("Lista feltöltése.")
	void listaFeltolteseTest() {
		Path utvonal = Path.of("data/eredmenyek.csv");
		AbcKosarlabdaLigaFeladatok.fajlBeolvasas(utvonal);
		// Ellenőrizzük, hogy a lista nem maradt-e üres
		assertTrue(AbcKosarlabdaLigaFeladatok.lista.size() > 0,
				"A listának tartalmaznia kell adatokat a beolvasás után!");
	}

	@Test
	@DisplayName("Lista feltöltése negatív teszt.")
	void listaFeltolteseNegativTest() {
		Path utvonal = Path.of("eredmenyek.csv");

		assertThrows(NullPointerException.class, () -> AbcKosarlabdaLigaFeladatok.fajlBeolvasas(utvonal));
	}

}