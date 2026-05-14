package kosar2004Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import kosar2004.AbcKosarlabdaLiga;
import kosar2004.AbcKosarlabdaLigaFeladatok;
import kosar2004.FajlKosarlabdaRepository;
import kosar2004.IKosarlabdaRepository;

public class AbcKosarlabdaLigaFeladatokTest {

	private IKosarlabdaRepository mockRepo;
	private IKosarlabdaRepository mokitomockRepo;
	private AbcKosarlabdaLigaFeladatok feladatok;

	// Valóságos és hamis metódus is egyszerre.
	private AbcKosarlabdaLigaFeladatok spyFeladatok;

	private Path utvonal = Path.of("java-console-exams/data/eredmenyek.csv");

	@BeforeEach // ctrl+shift+o az import fixálása
	void inicializalas() { // Minden teszt előtt lefut külön-külön.
		// 1. Létrehozzuk a mock adatforrást.
		mockRepo = new MockKosarlabdaRepository();
		mokitomockRepo = mock(IKosarlabdaRepository.class);

		// 2. Inicializáljuk a feladatokat végző osztályt a mock-al.
		// Így a feladatok osztály ezentúl a mockRepo-tól kéri az adatokat, nem a csv
		// fájlból.
		feladatok = new AbcKosarlabdaLigaFeladatok(mockRepo);

		// Spy létrehozása valódi objektumon keresztül.
		// A Spy egy valódi, létező objektumot csomagol be.
		spyFeladatok = spy(new AbcKosarlabdaLigaFeladatok(mockRepo));

	}

	@AfterEach
	void reseteles() { // Minden teszt után lefut külön-külön.
		mockRepo = null;
		mokitomockRepo = null;
		feladatok = null;
		spyFeladatok = null;
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
		assertTrue(program.getLista().size() > 0, "A listának tartalmaznia kell adatokat a beolvasás után!");
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
		assertThrows(IllegalArgumentException.class, () -> program.inditas());
	}

	@Test
	@Tag("Mockkolás.")
	@DisplayName("Leellenőrizzük a mock objektumot, hogy van-e benne valami.")
	void mockLeellenorzese() {
		// Indítás.
		feladatok.inditas();
		assertTrue(feladatok.getLista().size() > 0, "A mock listának tartalmaznia kell adatokat a beolvasás után!");
	}

	@Test
	@Tag("Mockkolás.")
	@DisplayName("Leellenőrizzük a mock objektumot, hogy a darabszám stimmel-e.")
	void mockDBLeellenorzese() {
		// Indítás.
		feladatok.inditas();

		int db = 6;

		assertTrue(feladatok.getLista().size() == db, "A mock listának " + db + " eleműnek kell");
	}

	@Test
	@Tag("Mockkolás.")
	@DisplayName("Kilistázás részleges ellenőrzése.")
	void kilistazasEllenorzese() {

		// syso-s kiíratás ellenőrzéséhez.
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

		feladatok.inditas();

		// Tesztelt syso kiiratása.
		feladatok.kiiratas();

		assertTrue(output.toString().contains("Real Madrid"));
	}

	@Test
	@Tag("Mockkolás.")
	@DisplayName("Hányszor játszott a Real Madrid összesen.")
	void hanyszorJatszottARealMadridOsszesen() {
		feladatok.inditas();

		assertEquals(feladatok.hanyszorJatszottARealMadridOsszesen(), 2, "Nem jó a RealMadrid meccs darabszáma.");
	}

	@Test
	@Tag("Mockkolás.")
	@DisplayName("Hányszor játszott a Real Madrid összesen.-> Egyszer sem.")
	void hanyszorJatszottARealMadridOsszesenEgyszerSem() {
		feladatok.inditas();

		AbcKosarlabdaLiga realMadridFelulIrasa0 = new AbcKosarlabdaLiga("Falco KC", "Barcelona", 88, 70, "Madrid",
				LocalDate.of(2024, 5, 10));
		mockRepo.setLista(1, realMadridFelulIrasa0);
		
		AbcKosarlabdaLiga realMadridFelulIrasa1 = new AbcKosarlabdaLiga("Lakers", "Barcelona", 88, 70, "Madrid",
				LocalDate.of(2024, 5, 10));
		mockRepo.setLista(2, realMadridFelulIrasa1);

		// Újra át kell adni a listát.
		feladatok = new AbcKosarlabdaLigaFeladatok(mockRepo);

		assertEquals(feladatok.hanyszorJatszottARealMadridOsszesen(), 0,
				"Nem jó a RealMadrid meccs darabszáma, mert 0-nak kéne lennie.");
	}

	@Test
	@Tag("Mockkolás.")
	@DisplayName("Hány döntetlen volt.")
	void hanyDontetlenVolt() {
		feladatok.inditas();

		assertEquals(feladatok.hanyDontetlenVolt(), 1, "Nem jó a döntetlen meccsek darabszáma.");
	}

	@Test
	@Tag("Mockkolás.")
	@DisplayName("Hány döntetlen volt mokito mock-al.-> Nincs egysem.")
	void hanyDontetlenVoltNincsIlyen() {
		feladatok.inditas();

		AbcKosarlabdaLiga dontetlenFelulIrasa = new AbcKosarlabdaLiga("Real Madrid", "Barcelona", 88, 70, "Madrid",
				LocalDate.of(2024, 5, 10));
		mockRepo.setLista(1, dontetlenFelulIrasa);
		// Újra át kell adni a listát.
		feladatok = new AbcKosarlabdaLigaFeladatok(mockRepo);

		assertEquals(feladatok.hanyDontetlenVolt(), 0,
				"Nem jó a döntetlen meccsek darabszáma, mert nullának kéne lennie.");
	}

	@Disabled // TODO
	@Test
	@Tag("Mokito mock.")
	@DisplayName("Hány döntetlen volt mokito mock-al.")
	void hanyDontetlenVoltSpy() {
		spyFeladatok.inditas();
		when(mockRepo.osszesMerkozesLekerese()).thenReturn(spyFeladatok.getLista());

		assertEquals(spyFeladatok.hanyDontetlenVolt(), 1, "Nem jó a döntetlen meccsek darabszáma.");
	}

}
