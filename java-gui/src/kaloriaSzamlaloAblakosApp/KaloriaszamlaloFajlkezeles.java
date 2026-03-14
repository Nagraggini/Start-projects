package kaloriaSzamlaloAblakosApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class KaloriaszamlaloFajlkezeles {

	static String[] adatok = new String[2];

	public static void fajlbeolvasasa(String fajlnev, boolean ujrainditas) throws IOException {

		File fajl = new File(fajlnev);

		// A karakterkódolást meg kell adni.
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(fajl), StandardCharsets.UTF_8));
		// fajlnev is lehet

		int sorokszama = 0;
		String sor;
		try {
			// Lehet üres a fájlt.
			while ((sor = br.readLine()) != null && sorokszama < adatok.length) { // Csak 2 sort olvas be.

				adatok[sorokszama] = sor;// A fájl következő sorát adja vissza.
				sorokszama++;

			}

		} catch (NullPointerException e) {

		}
		br.close();

		// Leellenőrizzük, hogy több sor van-e a fájlban, mint kettő.
		if (adatok.length >= 2) {
			KaloriaszamlaloFoprogram.kaloriaszamlaloPeldany.setNev(adatok[0]);

			if (ujrainditas == true) {
				// A program újraindításakor elég csak lekérni a napikaloria változó értékét.
				KaloriaszamlaloFoprogram.kaloriaszamlaloPeldany.getNapiKaloria();
			} else {
				// Induláskor, meg szükséges beállítani azt. Ez nem újraindításgomb megnyomása
				// után történik.
				KaloriaszamlaloFoprogram.kaloriaszamlaloPeldany.setNapiKaloria(Integer.parseInt(adatok[1]));
			}
		}

	}

	public static void faljKiiratas(String fajlnev) throws IOException {

		// Java 11+-os megoldás.
		Files.writeString(Path.of(fajlnev), KaloriaszamlaloFoprogram.kaloriaszamlaloPeldany.getNev() + "\n"
				+ KaloriaszamlaloFoprogram.kaloriaszamlaloPeldany.getNapiKaloria(), StandardCharsets.UTF_8);

	}

}
