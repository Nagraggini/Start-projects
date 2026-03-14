package kaloriaSzamlaloAblakosApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

//Rögtön a JFrameből származtatom az osztályt. Öröklés.
public class KaloriaszamlaloFoprogram extends JFrame implements ActionListener {

	// Az alkalmazás írja ki a nap végi értéket.

	private static final long serialVersionUID = 1L; // A JFrame-ből öröklés miatt kell.

	// Az ablakon elhelyezett komponensek.
	private static JTextField nevBeviteliMezo;

	private JTextField kaloriaBeviteliMezo;
	private JButton nevGomb, megettemGomb, sportolasGomb, pihenesGomb, ujrainditasGomb;
	private static JLabel napVegiErtek;

	public static String fajlnev = "adatok.txt";

	public static Kaloriaszamlalo kaloriaszamlaloPeldany = new Kaloriaszamlalo();

	// Konstruktor:
	public KaloriaszamlaloFoprogram() {

		setSize(950, 500); // szélessség, magasság

		// Így tényleg bezáródik a program az x megnyomására és nem fog tovább futni a
		// háttérben.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Fő ablak layout-ja BorderLayout, így a panel felveszi a szükséges helyet
		setLayout(new BorderLayout());

		// Panelek létrehozása és layout beállítása
		JPanel felsoPanel = new JPanel(new GridLayout(3, 2, 10, 10)); // sorok, oszlopok, és a két padding
		felsoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20)); // top, left, bottom, right

		JPanel alsoPanel = new JPanel(new GridLayout(2, 1, 10, 10));

		// Beviteli mezők:
		nevBeviteliMezo = new JTextField(20); // Hány karakter fér bele.
		kaloriaBeviteliMezo = new JTextField(10); // Hány karakter fér bele.

		// Gombok
		nevGomb = new JButton("Név mentése");
		megettemGomb = new JButton("Megettem (kcal)");
		sportolasGomb = new JButton("Sportolás (egy óra/600 kcal)");
		pihenesGomb = new JButton("Pihenés (egy óra/40 kcal)");

		ujrainditasGomb = new JButton("Restart");

		napVegiErtek = new JLabel();

		// Színek
		napVegiErtek.setOpaque(true); // EZ KÖTELEZŐ
		napVegiErtek.setBackground(new Color(51, 204, 255));

		// Kattintások eseménykezelése
		nevGomb.addActionListener(this);
		megettemGomb.addActionListener(this);
		sportolasGomb.addActionListener(this);
		pihenesGomb.addActionListener(this);
		ujrainditasGomb.addActionListener(this);

		// Hozzáadom a panelhez a komponenseket
		felsoPanel.add(nevBeviteliMezo);
		felsoPanel.add(nevGomb);
		felsoPanel.add(kaloriaBeviteliMezo);
		felsoPanel.add(megettemGomb);
		felsoPanel.add(sportolasGomb);
		felsoPanel.add(pihenesGomb);

		alsoPanel.add(napVegiErtek, BorderLayout.CENTER);
		alsoPanel.add(ujrainditasGomb, BorderLayout.CENTER);

		// A panelt hozzáadom az ablakhoz a BorderLayout CENTER részéhez
		add(felsoPanel, BorderLayout.CENTER);
		add(alsoPanel, BorderLayout.SOUTH); // Lentre helyezem.

		setLocationRelativeTo(null); // Középre helyezés.
		setVisible(true); // Láthatóvá állítjuk.
	}

	/** Betűtípus beállítása mindenhol. */
	public static void globalisFontBeallitasa(Font font) {
		Enumeration<Object> keys = UIManager.getDefaults().keys();

		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);

			if (value instanceof FontUIResource) {
				UIManager.put(key, new FontUIResource(font));
			}
		}
	}

	/** Segédfüggvény a mező ellenőrzésére */
	private boolean hosszusagCsekkolasa(String input) {
		return input.length() >= 1;
	}

	/** Lecsekkoljuk, hogy nincs-e benne szám stb. */
	private static boolean nevEllenorzese(String keresztnev) {

		// Szám, írásjel, szóköz nem számít karakternek.
		for (char karakter : keresztnev.toCharArray()) {// toCharArray átkonvertálja a string-et egy char-ra.
			// A szóközt, így nem veszi hibás inputnak.
			if (!Character.isLetter(karakter) && karakter != ' ') {
				return false; // Nincsen benne betű.
			}
		}
		return true;
	}

	/** Csak számot fogadunk el. */
	private boolean kaloriaEllenorzese(String kaloria) {

		try {
			Integer.parseInt(kaloria);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public static void napiErtekAlsoCimkeBeallitasa() {

		String nev = kaloriaszamlaloPeldany.getNev();

		// Ha a név null vagy üres, ne írjunk semmit, ternális operátorral
		String megjelenitoNev = (nev == null || nev.isEmpty()) ? "" : " " + nev;

		napVegiErtek.setText(
				"Szia" + megjelenitoNev + "! Ennyi a napi kalóriád: " + kaloriaszamlaloPeldany.getNapiKaloria());
	}

	/** Gombok eseménykezelése. */
	@Override
	public void actionPerformed(ActionEvent e) {

		Object lenyomottGombId = e.getSource(); // Az adott gomb id-t tartalmazza.

		if (lenyomottGombId == nevGomb) {
			// Lecsekkoljuk, hogy nem üres-e,vagy számot tartalmaz-e a név, a szóköz okés.
			if (hosszusagCsekkolasa(nevBeviteliMezo.getText()) && nevEllenorzese(nevBeviteliMezo.getText())) {
				JOptionPane.showMessageDialog(null, "Sikeres mentés!", "Megadott érték ellenőrzése",
						JOptionPane.INFORMATION_MESSAGE);

				// Beállítjuk a nevet.
				kaloriaszamlaloPeldany.setNev(nevBeviteliMezo.getText());

				napiErtekAlsoCimkeBeallitasa();
				try {
					KaloriaszamlaloFajlkezeles.faljKiiratas(fajlnev);
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Sikertelen mentés! Hibás input.", "Megadott érték ellenőrzése",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (lenyomottGombId == megettemGomb) {
			// Hosszúság lecsekkolása.
			if (hosszusagCsekkolasa(kaloriaBeviteliMezo.getText())
					&& kaloriaEllenorzese(kaloriaBeviteliMezo.getText())) {
				JOptionPane.showMessageDialog(null, "Sikeres mentés!", "Megadott érték ellenőrzése",
						JOptionPane.INFORMATION_MESSAGE);

				// Beállítjuk a bekért értéket.
				kaloriaszamlaloPeldany.setNapiKaloria(Integer.parseInt(kaloriaBeviteliMezo.getText()));

				napiErtekAlsoCimkeBeallitasa();

				try {
					KaloriaszamlaloFajlkezeles.faljKiiratas(fajlnev);
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Sikertelen mentés! Hibás input.", "Megadott érték ellenőrzése",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (lenyomottGombId == sportolasGomb) {
			// Beállítjuk a kalóriát.

			kaloriaszamlaloPeldany.sportolas();

			napiErtekAlsoCimkeBeallitasa();

			try {
				KaloriaszamlaloFajlkezeles.faljKiiratas(fajlnev);
			} catch (IOException e1) {

				e1.printStackTrace();
			}

			if (kaloriaszamlaloPeldany.getNapiKaloria() < 0) {
				JOptionPane.showMessageDialog(null, "Egyél valamit!", "Enyje-bejnye", JOptionPane.WARNING_MESSAGE);
			}
		}

		if (lenyomottGombId == pihenesGomb) {
			// Beállítjuk a kalóriát.
			kaloriaszamlaloPeldany.pihenes();

			napiErtekAlsoCimkeBeallitasa();

			try {
				KaloriaszamlaloFajlkezeles.faljKiiratas(fajlnev);
			} catch (IOException e1) {

				e1.printStackTrace();
			}

			if (kaloriaszamlaloPeldany.getNapiKaloria() < 0) {
				JOptionPane.showMessageDialog(null, "Egyél valamit!", "Enyje-bejnye", JOptionPane.WARNING_MESSAGE);
			}

		}

		if (lenyomottGombId == ujrainditasGomb) {
			dispose(); // Eltűntetjük az előző ablakot.

			// Lambda
			SwingUtilities.invokeLater(() -> {
				new KaloriaszamlaloFoprogram();

				// Fájl beolvasása
				try {// Csak megjeleníteni kell az adatokat. getNapiKaloria()
					KaloriaszamlaloFajlkezeles.fajlbeolvasasa(fajlnev, true);
				} catch (IOException e2) {
					e2.printStackTrace();
				}

				// JLabel frissítése
				napiErtekAlsoCimkeBeallitasa();
			});

		}
	}

	public static void main(String[] args) throws FontFormatException, IOException {

		// Betűtípus beállítása
		try {
			Font sajatFont = Font
					.createFont(Font.TRUETYPE_FONT, new File("src/KaloriaszamlaloApp/Assets/Fonts/Ayuma2yk.ttf"))
					.deriveFont(40f);
			globalisFontBeallitasa(sajatFont);
		} catch (Exception e) {
			// Ha nincs meg a font fájl, akkor ez érvényesül.
			globalisFontBeallitasa(new Font("Dialog", Font.BOLD, 18));
		}

		// Fontos a sorrend: Ablak megjelenítése, fájl beolvasás, JLabel frissítés
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Ablak létrehozása
				new KaloriaszamlaloFoprogram();

				// Fájl beolvasása
				try {
					KaloriaszamlaloFajlkezeles.fajlbeolvasasa(fajlnev, false);
				} catch (IOException e) {
					e.printStackTrace();
				}

				// JLabel frissítése
				napiErtekAlsoCimkeBeallitasa();
			}
		});
	}
}
