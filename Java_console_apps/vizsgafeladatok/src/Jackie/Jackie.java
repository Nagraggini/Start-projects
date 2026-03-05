package Jackie;

public class Jackie {

    // Adattagok:
    private int year; // versenyzés éve
    private int races; // hány versenyen indult
    private int wins; // hány versenyt nyert meg
    private int podiums; // hányszor volt dobogós eredménye
    private int poles; // hányszor indult első helyről
    private int fastests; // hányszor volt az övé a leggyorsabb kör

    // Konstruktor:
    // year races wins podiums poles fastests ||| Sorrendre figyelj!
    public Jackie(int year, int races, int wins, int podiums, int poles, int fastests) {
        this.year = year;
        this.races = races;
        this.wins = wins;
        this.podiums = podiums;
        this.poles = poles;
        this.fastests = fastests;
    }

    // Getterek és setterek:
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRaces() {
        return races;
    }

    public void setRaces(int races) {
        this.races = races;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getPodiums() {
        return podiums;
    }

    public void setPodiums(int podiums) {
        this.podiums = podiums;
    }

    public int getPoles() {
        return poles;
    }

    public void setPoles(int poles) {
        this.poles = poles;
    }

    public int getFastests() {
        return fastests;
    }

    public void setFastests(int fastests) {
        this.fastests = fastests;
    }

    // Az értékek egy soros kiíratásához:
    @Override
    public String toString() {
        return "Jackie [year=" + year + ", races=" + races + ", wins=" + wins + ", podiums=" + podiums + ", poles="
                + poles + ", fastests=" + fastests + "]";
    }

}
