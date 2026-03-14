package alapokGyakorlasa;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Alap szint – változók, műveletek
 */
public class AlapokGyakorlasa {
	/**
	 * Alap szint – változók, műveletek
	 */
	public static void Alapmuveletek() {
		double radius;
		Scanner scanner = new Scanner(System.in);

		/*
		 * 🔹 Alap szint – változók, műveletek
		 * 
		 * Írj programot, amely kiírja a nevedet, lakhelyedet és kedvenc színedet külön
		 * sorokba!
		 */
		System.out.println("Alap szint – változók, műveletek");

		System.out.println("Andi,\n Budapest,\n kék");

		// Kérj be a felhasználótól két számot, és írd ki az összegüket!
		System.out.println("Adj meg két számot vesszővel elválasztva:");
		String numbers = scanner.nextLine();

		String[] myArray = numbers.split(",");
		// .trim() -> Eltávolítja a felesleges szóközöket.

		int num1 = Integer.parseInt(myArray[0].trim());
		int num2 = Integer.parseInt(myArray[1].trim());

		System.out.println(num1 + num2);

		// Kérj be egy számot, és írd ki, hogy a szám kétszerese mennyi!
		System.out.println("Adj meg egy számot:");
		int number = scanner.nextInt();
		System.out.println(number * 2);

		// Kérj be egy hőmérsékletet Celsiusban, és alakítsd át Fahrenheitre!
		System.out.println("Ad meg a hőmérsékletet celsiusban, vesszőt használj:");
		double temperature = scanner.nextDouble();
		System.out.println("Fahrenheitben: " + ((temperature * 9 / 5) + 32));

		// Kérj be egy kör sugarát, és számítsd ki a kör kerületét és területét!
		System.out.println("Ad meg a kör sugarát:");
		radius = scanner.nextDouble();
		double circumference = 2 * radius * Math.PI;
		double area = Math.PI * Math.pow(radius, 2);
		System.out.println("Kör kerülete: " + circumference);
		System.out.println("Kör területe: " + area);

		scanner.close(); // Bezárom a szkennert.
	}

	public static void BekertSzamokbolKiirjaALegnagyobbat() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Adja meg három számot, vesszővel elválasztva,\n és kiírom ,hogy ,melyik a legnagyobb!");
		String numbers = scanner.nextLine();

		ArrayList<Integer> list = new ArrayList<>();
		String[] myArray = numbers.split(","); // Szétvágjuk a vesszők mentén.
		int max2 = 0;
		for (int idx = 0; idx < myArray.length; idx++) {
			// trim() kiszedi a felesleges szóközöket.
			list.add(Integer.parseInt(myArray[idx].trim()));
			max2 = Math.max(max2, Integer.parseInt(myArray[idx].trim()));
		}

		int max = list.get(0);// Az első elem.
		for (int num : list) { // Végig megyünk a listán.
			/*
			 * TERNÁLIS OPERÁTOR if ciklus: max = if (num>max){ Igaz ág} else {Hamis ág.}
			 */
			max = (num > max) ? num : max;

		}
		System.out.println("A legnagyobb szám: " + max + " , max2:" + max2);
		scanner.close();

	}

	public static void BekertSzamokbolKiirjaALegnagyobbat_2() {
		Scanner scanner = new Scanner(System.in);

		System.out
				.println("Adja meg három számot, vesszővel elválasztva,\n " + "és kiírom ,hogy ,melyik a legnagyobb!");
		String numbers = scanner.nextLine();

		String[] myArray = numbers.split(","); // Szétvágjuk a vesszők mentén.
		int max2 = 0;
		for (int idx = 0; idx < myArray.length; idx++) {
			// trim() kiszedi a felesleges szóközöket.
			max2 = Math.max(max2, Integer.parseInt(myArray[idx].trim()));
		}

		System.out.println("A legnagyobb szám: " + max2);
		scanner.close();
	}

	/**
	 * Elágazások gyakorlása. Ternális operátor.
	 */
	public static void BekertSzamrolKiirjaParosVagyParatlan() {
		/*
		 * 🔹 Elágazások
		 * 
		 * Kérj be egy számot, és döntsd el róla, hogy páros vagy páratlan!
		 */

		System.out.println("Elágazások gyakorlása.");

		Scanner sc = new Scanner(System.in);
		System.out.println("Adj meg egy egész számot és eldöntöm róla, hogy páros, vagy páratlan.");
		int num = Integer.parseInt(sc.next());

		// Ternális operátor
		System.out.println((num % 2 == 0) ? "páros" : "páratlan");

		sc.close();
	}

	/**
	 * Elágazások gyakorlása folytatás.
	 */
	public static void EletkorEllenorzo() {
		System.out.println("Adj meg egy életkort, és írd kiírom, hogy kiskorú, felnőtt vagy nyugdíjas-e!");
		Scanner sc = new Scanner(System.in);

		int age = sc.nextInt();

		if (18 <= age && age < 65) {
			System.out.println("Felnőtt");
		} else if (age < 18) {
			System.out.println("Kiskorú");
		} else {
			System.out.println("Nyugdíjas");
		}

		sc.close();
	}

	/**
	 * Elágazások gyakorlása
	 */
	public static void BekertSzamokKozulKiirjaALegnagyobbat() {

		System.out.println("Adj meg három számot vesszővel elválasztva, és kiírom, melyik a legnagyobb!");
		Scanner sc = new Scanner(System.in);
		String numbers = sc.nextLine();
		String[] numbers2 = numbers.split(",");

		int max = Integer.parseInt(numbers2[0]); // Negatív számok esetén, nem jó a 0.
		for (int i = 0; i < numbers2.length; i++) {

			max = Math.max(Integer.parseInt(numbers2[i].trim()), max);
		}
		System.out.println("A legnagyobb szám: " + max);
		sc.close();
	}

	/**
	 * Switch ciklus
	 */
	public static void OsztalyzatKiirasaSzovegesen() {
		// Csak egyszer fut le.
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Adj meg egy érdemjegyet (1-5-ig), \n és kiírom szövegesen az eredményt (elégtelen, jeles, stb).");

		// Leellenőrizzük, hogy tuti számot adott-e meg a felhasználó.
		if (sc.hasNextInt()) {
			int grade = sc.nextInt();

			switch (grade) {
			case 1:
				System.out.println("Elégtelen.");
				break;
			case 2:
				System.out.println("Elégséges.");
				break;
			case 3:
				System.out.println("Közepes.");
				break;
			case 4:
				System.out.println("Jó.");
				break;
			case 5:
				System.out.println("Jeles.");
				break;
			default:
				System.out.println("1 és 5 között adj meg egy számot.");
			}
			sc.close();

		} else {
			System.out.println("Nem számot adtál meg.");
		}
	}

	/**
	 * Másik megoldás
	 */
	public static void OsztalyzatKiirasaSzovegesen_2() {
		Scanner sc = new Scanner(System.in);
		int grade;

		do {
			System.out.print("Adj meg egy érdemjegyet (1–5): ");

			if (!sc.hasNextInt()) { // Nem számot adott meg a felhasználó.
				System.out.println("Nem egész számot adtál meg, vagy szöveget!");
				sc.next(); // hibás input eldobása
				grade = 0; // biztosan rossz érték
				continue; // Hagyd abba a ciklus aktuális körét, és ugorj a következőre.
			}

			grade = sc.nextInt();

			if (grade < 1 || grade > 5) {
				System.out.println("Hibás érték! 1 és 5 között add meg.");
			}

		} while (grade < 1 || grade > 5);

		// Java 14+ switch expression, Lambda
		switch (grade) {
		case 1 -> System.out.println("Elégtelen."); // A break-t sem kell kiírni.
		case 2 -> System.out.println("Elégséges.");
		case 3 -> System.out.println("Közepes.");
		case 4 -> System.out.println("Jó.");
		case 5 -> System.out.println("Jeles.");
		}

		sc.close();
	}

	/**
	 ** A switch nem feltételeket, hanem konkrét értékeket vizsgál; tartományok
	 * ellenőrzésére if–else szerkezetet használunk.
	 */
	public static void EletkorEllenorzo_2() {
		Scanner sc = new Scanner(System.in);
		int number = -1; // kezdeti rossz érték a ciklushoz

		while (true) {
			System.out.print("Adj meg egy életkort: ");

			try {
				number = sc.nextInt();

				if (number < 0 || number > 120) {
					System.out.println("Az életkor 0 és 120 között legyen!");
					continue; // újra bekéri
				}

				// tartományok
				if (number <= 5) {
					System.out.println("Csecsemő / kisgyermek");
				} else if (number <= 12) {
					System.out.println("Gyermek");
				} else if (number <= 18) {
					System.out.println("Tizenéves");
				} else if (number <= 65) {
					System.out.println("Felnőtt");
				} else {
					System.out.println("Nyugdíjas");
				}

				break; // sikeres input → kilép a ciklusból

			} catch (InputMismatchException e) {
				System.out.println("Nem számot adtál meg!");
				sc.next(); // hibás input eldobása
			}
		}

		sc.close();
	}

	/** Do-while és if eláhazás gyakorlása. */

	public static void EgyEsTizKozottiSzamBekerese() {
		Scanner sc = new Scanner(System.in);
		int number;

		do {
			System.out.println("Adj meg egy számot, ami 1 és 10 között van.");

			if (!sc.hasNextInt()) {
				System.out.println("Hibás érték, próbáld újra!");
				sc.next(); // hibás input eldobása
				number = 0; // a while feltétel miatt
				continue; // Ez azért kell hogy két rontás után, ne álljon le a program.
			}

			// Megadjuk a változó értékét, inicializáljuk.
			number = sc.nextInt();

			if (number < 1 || number > 10) {// Hibás érték.
				System.out.println("Túl nagy vagy túl kicsi az érték. \n Újra!");
			}

		} while (number < 1 || number > 10);

		System.out.println("Jó a szám, 1 és 10 között van!");
		sc.close();
	}

	/** Do-while és if gyarkolása. */
	public static void ParosSzamBekerese() {
		Scanner sc = new Scanner(System.in);
		int number;

		do {

			System.out.println("Adj meg egy páros számot:");
			number = sc.nextInt();
			if (number % 2 == 0) {
				System.out.println("Páros a szám.");
			}

		} while (number % 2 != 0); // Páros a szám.
		sc.close();
	}

	/** Do-while és if gyarkolása. */
	public static void BekertSzamokOsszeadasa() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int number;

		do {
			System.out.println(
					"Adj meg több számot, mindegyik után nyomj egy entert és összeadom őket, addig amíg nem 0-át adsz meg.");
			number = sc.nextInt(); // Ezzel kérünk be a felhasználótól számot.

			sum += number;

			System.out.println("Összeadás eredménye: " + sum);
		} while (number != 0);
		sc.close();
	}

}
