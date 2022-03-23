package DomianObjects;

public class Konto {
    private String navn;
    private String kode;
    private int saldo;

    public Konto(String navn, String kode, int saldo) {
        this.navn = navn;
        this.kode = kode;
        this.saldo = saldo;
    }

    public String getNavn() {
        return navn;
    }

    public String getKode() {
        return kode;
    }

    public int getSaldo() {
        return saldo;
    }


    public int indsæt(int i) {
        if (i > 0) {
        saldo = saldo + i;
      }
        return saldo;
    }

    public int hæv(int i) {
        if (i > saldo) {
            return saldo;
        }

        saldo = saldo - i;

        return saldo;
    }
}
