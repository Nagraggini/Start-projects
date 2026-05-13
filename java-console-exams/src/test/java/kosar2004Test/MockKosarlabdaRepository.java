package kosar2004Test;

import java.time.LocalDate;
import java.util.ArrayList;

import kosar2004.AbcKosarlabdaLiga;
import kosar2004.IKosarlabdaRepository;

//Ez a Mock osztály. Színlelt/mű objektum/adatforrás a teszteléshez.
public class MockKosarlabdaRepository implements IKosarlabdaRepository {

	@Override
	public ArrayList<AbcKosarlabdaLiga> osszesMerkozesLekerese() {
		ArrayList<AbcKosarlabdaLiga> mockLista = new ArrayList<>();
	
		LocalDate idopont = LocalDate.now().minusMonths(1);
		
		// Fix tesztadatok a teszteléshez.
		mockLista.add(new AbcKosarlabdaLiga("7up", "6down", 81, 73, "Barcelona", idopont));
		mockLista.add(new AbcKosarlabdaLiga("Real Madrid", "Barcelona", 88, 85, "Madrid", LocalDate.of(2024, 5, 10)));
		mockLista
				.add(new AbcKosarlabdaLiga("Lakers", "Real Madrid", 120, 92, "Los Angeles", LocalDate.of(2024, 5, 11)));
		mockLista.add(
				new AbcKosarlabdaLiga("Olympiacos", "Fenerbahce", 62, 58, "Piraeus", LocalDate.now().minusDays(3)));
		mockLista.add(new AbcKosarlabdaLiga("Falco KC", "Alba Fehérvár", 94, 82, "Szombathely",
				LocalDate.now().minusWeeks(2)));
		mockLista.add(new AbcKosarlabdaLiga("Bulls", "Celtics", 101, 115, "Chicago", LocalDate.of(2024, 4, 20)));

		return mockLista;
	}
}
