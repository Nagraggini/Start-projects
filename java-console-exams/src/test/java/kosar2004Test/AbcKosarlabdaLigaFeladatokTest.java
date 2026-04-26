package test.java.kosar2004Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
		abckosarlabdafeladatokObj = new AbcKosarlabdaLigaFeladatok();
	}
	
	@AfterEach
	void reseteles() {
		abckosarlabdafeladatokObj.lista=null;
	}
	
	@Test
	@DisplayName("Lista feltöltése.")
	void listaFeltolteseTest() {
		Path utvonal=Path.of("data/eredmenyek.csv");
		AbcKosarlabdaLigaFeladatok.fajlBeolvasas(utvonal);
		// TODO
		// Ellenőrizzük, hogy a lista nem maradt-e üres
		assertTrue(AbcKosarlabdaLigaFeladatok.lista.size() > 0,
				"A listának tartalmaznia kell adatokat a beolvasás után!");
	}

	@Test
	@DisplayName("Lista feltöltése negatív teszt.")
	void listaFeltolteseNegativTest() {
		Path utvonal=Path.of("eredmenyek.csv");
			
		assertThrows(NullPointerException.class,()-> AbcKosarlabdaLigaFeladatok.fajlBeolvasas(utvonal));
	}
}