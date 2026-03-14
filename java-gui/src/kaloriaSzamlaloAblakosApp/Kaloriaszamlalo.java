package kaloriaSzamlaloAblakosApp;

public class Kaloriaszamlalo {
	// Önálló (otthoni) feladat

	// Készítsen egy napi kalóriaszámláló alkalmazást.

	// Adattagok privátok az adatelrejtésnek megfelelően.
	// Adattagok: név; napi kalória

	private String nev;
	private int napiKaloria;

	// Konstrtuktor:
	public Kaloriaszamlalo() {
		napiKaloria = 0;
	}

	// Getterek és setterek:
	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public int getNapiKaloria() {
		return napiKaloria;
	}

	// táplálkozás (megettem gomb) -> a megadott kalória mennyiségével növekszik a
	// napi érték
	public void setNapiKaloria(int napiKaloria) {
		this.napiKaloria += napiKaloria;
	}

	// Metódusok:

	// sportolás -> minden sportolással töltött óra 600 kalória elégetését jelenti
	public void sportolas() {
		// napiKaloria-600
		napiKaloria -= 600;
	}

	// pihenés -> minden pihenéssel töltött óra 40 kalória elégetését jelenti
	public void pihenes() {
		// napiKaloria-40
		napiKaloria -= 40;
	}

}
