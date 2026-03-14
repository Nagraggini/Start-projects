package sentenceGenerator;

public class Game {

    public String generator() {
        String[] firstWord = {"Nagyon jó", "Megbízható", "Érdeklődő", "Szorgalmas", "Türelmes", "Tökéletes"};
        String[] secondWord = {"megoldás", "lehetőség", "kivitelezés"};
        String[] thirdWord = {"neked!", "nekünk!", "mindenkinek!", "az egész világnak!"};

        int oneLenght = firstWord.length;
        int secondLenght = secondWord.length;
        int thirdLenght = thirdWord.length;

        //Math.random() 0 0.999999 közötti számod ad vissza.
        int random1 = (int) (Math.random() * oneLenght);
        int random2 = (int) (Math.random() * secondLenght);
        int random3 = (int) (Math.random() * thirdLenght);

        //0.1 - generátor X 5 = 0.5
        //0.9 - generátor X 5 = 4.5
        //Mivel az (int) kasztolás leveszi a tizedes utáni értéket.
        //0-4 köz9tt értéket kapunk visza.
        String sentence = firstWord[(int) (Math.random() * firstWord.length)] + " " + secondWord[random2] + " " + thirdWord[random3];

        return sentence;

    }
}
