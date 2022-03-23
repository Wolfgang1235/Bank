package DomianObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Konto {
    private String navn;
    private String kode;
    private int kontoNummer;
    private int saldo;

    public Konto(String navn, String kode, int kontoNummer, int saldo) {
        this.navn = navn;
        this.kode = kode;
        this.kontoNummer = kontoNummer;
        this.saldo = saldo;
    }

    public String getNavn() {
        return navn;
    }

    public String getKode() {
        return kode;
    }

    public int getKontoNummer() {
        return kontoNummer;
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

    public boolean overførTilAndenKonto(Map<String,Konto> konti, int kontoNummer, int i) {
        List<Integer> kontoNumre = new ArrayList<>();
        konti.forEach((k,v) -> {
            kontoNumre.add(v.kontoNummer);
        });
        if (!kontoNumre.contains(kontoNummer)) {
            return false;
        }
        this.hæv(i);

        return true;
    }
}
