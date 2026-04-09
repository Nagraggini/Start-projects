package generikusprog;

public class MainProduct {

    // Generikus programozás.
    public static void main(String[] args) {

        // 1. PÉLDA: Szöveg tárolása (String)
        // Itt a T helyére a String kerül
        Box<String> labelBox = new Box<>();
        labelBox.add("Törékeny áru");
        String label = labelBox.get(); // Nincs szükség (String) castolásra!
        System.out.println("Címke tartalma: " + label);

        // 2. PÉLDA: Saját objektum tárolása (Product)
        // Itt a T helyére a Product osztály kerül
        Box<Product> productBox = new Box<>();
        productBox.add(new Product("Vezeték nélküli egér", 8500.0));

        Product myProduct = productBox.get();
        System.out.println("A dobozban lévő termék: " + myProduct);

        // 3. MIÉRT JÓ EZ? (Típusbiztonság)
        // A következő sor fordítási hibát okozna, mert a productBox-ba
        // csak Product objektumot enged a Java, Stringet nem:
        // productBox.add("Ez nem egy termék");
    }

}
