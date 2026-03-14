package hasznosInfok;

// Egyszerű osztály az adatok tárolására
class Operatorok2 {

    private int bal;
    private String operator;
    private int jobb;

    public Operatorok2(int bal, String operator, int jobb) {
        this.bal = bal;
        this.operator = operator;
        this.jobb = jobb;
    }

    public int getBal() {
        return bal;
    }

    public String getOperator() {
        return operator;
    }

    public int getJobb() {
        return jobb;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Operatorok2{");
        sb.append("bal=").append(bal);
        sb.append(", operator=").append(operator);
        sb.append(", jobb=").append(jobb);
        sb.append('}');
        return sb.toString();
    }

}
