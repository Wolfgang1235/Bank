package DomianObjects;

public class TransaktionsObjekt {
    private String dato;
    private int transaktionsBeløb;
    private int saldo;

    public TransaktionsObjekt(String dato, int transaktionsBeløb, int saldo) {
        this.dato = dato;
        this.transaktionsBeløb = transaktionsBeløb;
        this.saldo = saldo;
    }

    public String getDato() {
        return dato;
    }

    public int getTransaktionsBeløb() {
        return transaktionsBeløb;
    }

    public int getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "dato " + dato + " beløb " + transaktionsBeløb + " saldo " + saldo;
    }
}
