package elsoAblakosAlkalmazas;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWindow {

	public static void main(String[] args) {
		JFrame window = new JFrame("Example GUI");
		JLabel label = new JLabel("Hello");

		window.setSize(400, 400);
		window.add(label);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// az ablak bezáródik, de a program a háttérben fut tovább

		window.setLocationRelativeTo(null); // középre teszi

		window.setVisible(true);

	}

}
