package main.java.kosar2004;

import java.util.ArrayList;

/*
 * Interface: Metódus halmaz, ahol a metódusok szignaturája jelennek meg, az
 * osztály ami örökli azt fog megvalósítani a metódusokat.
 */

public interface IKosarlabdaRepository {
	/*
	 * Könnyebben karbantarthatóbb, ha külön van az interfész a logikától. Akár egy
	 * metódus paramétereként meg jelenhet az interfész típusa.
	 */
	// Visszaadja az összes mérkőzést (mindegy, hogy fájlból vagy memóriából)
	ArrayList<AbcKosarlabdaLiga> osszesMerkozesLekerese();

}
