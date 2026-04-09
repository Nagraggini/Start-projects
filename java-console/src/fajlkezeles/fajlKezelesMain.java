package fajlkezeles;

import java.io.File;
import java.io.IOException;

public class fajlKezelesMain {

    public static void main(String[] args) {

        try {
            File file = new File("fajlnev.txt");
            if (file.createNewFile()) {
                System.out.println("A fájl létrehozva ide: " + file.getName()); // System.out.println(file.getAbsoluteFile());

            } else {
                System.out.println("A fájl már létezik. " + file.exists());
                System.out.println(".canWrite(): " + file.canWrite()); // ".canWrite(): "+
                System.out.println(".canRead(): " + file.canRead()); // ".canWrite(): "+
                file.delete();
                System.out.println("Fájl törlése sikeres.");

                System.out.println(file.getAbsolutePath()); // System.out.println(file.getAbsoluteFile());
            }
        } catch (IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }

    }

}
