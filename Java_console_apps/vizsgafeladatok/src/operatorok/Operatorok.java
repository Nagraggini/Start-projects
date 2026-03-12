package operatorok;

public class Operatorok {

    // Adat tagok

    private int elsoAdat;
    private String operator;
    private int masodikAdat;

    // Kontruktor
    public Operatorok(int elsoAdat, String operator, int masodikAdat) {
        this.elsoAdat = elsoAdat;
        this.masodikAdat = masodikAdat;
        this.operator = operator;
    }

    public int getElsoAdat() {
        return elsoAdat;
    }

    public String getOperator() {
        return operator;
    }

    public int getMasodikAdat() {
        return masodikAdat;
    }

    @Override
    public String toString() {
        /*
         * StringBuilder sb = new StringBuilder(); sb.append("Operatorok{");
         * sb.append("elsoAdat=").append(elsoAdat);
         * sb.append(", operator=").append(operator);
         * sb.append(", masodikAdat=").append(masodikAdat); sb.append('}'); return
         * sb.toString();
         */

        return elsoAdat + " " + operator + " " + masodikAdat;
    }

}
