package test.java.kosar2004Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import main.java.kosar2004.AbcKosarlabdaLigaFeladatok;

public class AbcKosarlabdaLigaTest {

    @Test
    public void testListaFeltoltes() {
        // Meghívjuk a main-t, ami beolvassa a CSV-t
        // Megjegyzés: Ügyelj rá, hogy a CSV a megadott relatív úton elérhető legyen!
        String[] args = {};
        AbcKosarlabdaLigaFeladatok.main(args);

        // Ellenőrizzük, hogy a lista nem maradt-e üres
        assertTrue(AbcKosarlabdaLigaFeladatok.lista.size() > 0, "A listának tartalmaznia kellene adatokat a beolvasás után!");
    }
}