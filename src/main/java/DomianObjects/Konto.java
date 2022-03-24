package DomianObjects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Konto {
    private String navn;
    private String kode;
    private int kontoNummer;
    private int saldo;
    private int kasseKredit;
    private BrugerListe brugerListe;
    private TransaktionsListe transaktionsListe;

    public Konto(String navn, String kode, int kontoNummer, int saldo, int kasseKredit,
                 BrugerListe brugerListe,TransaktionsListe transaktionsListe) {
        this.navn = navn;
        this.kode = kode;
        this.kontoNummer = kontoNummer;
        this.saldo = saldo;
        this.kasseKredit = kasseKredit;
        this.brugerListe = brugerListe;
        this.transaktionsListe = transaktionsListe;
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

    public int getKasseKredit() {
        return kasseKredit;
    }

    public BrugerListe getBrugerListe() {
        return brugerListe;
    }

    public TransaktionsListe getTransaktionsListe() {
        return transaktionsListe;
    }

    public int indsæt(int i, Integer kontoNummer) {

        if (!brugerListe.checkBrugerInList(kontoNummer)) {
            return saldo;
        }

        if (i > 0) {
            saldo = saldo + i;

            String dato = String.valueOf(LocalDate.now());

            insertTransactionList(new TransaktionsObjekt(dato,i,saldo));
        }


        return saldo;
    }

    public int hæv(int i, Integer kontonummer) {
        if (!brugerListe.checkBrugerInList(kontonummer)) {
            return saldo;
        }

        if (i > saldo + kasseKredit) {
            return saldo;
        }
        String dato = String.valueOf(LocalDate.now());

        saldo = saldo - i;

        insertTransactionList(new TransaktionsObjekt(dato,i,saldo));

        return saldo;
    }

    public void insertTransactionList(TransaktionsObjekt transaktionsObjekt) {
        transaktionsListe.addToList(transaktionsObjekt);

    }

    public boolean overførTilAndenKonto(Map<String,Konto> konti, int kontoNummer, int i, Integer indsætKontonummer) {
        List<Integer> kontoNumre = new ArrayList<>();
        konti.forEach((k,v) -> {
            kontoNumre.add(v.kontoNummer);
        });
        if (!kontoNumre.contains(indsætKontonummer)) {
            return false;
        }
        this.hæv(i,kontoNummer);

        return true;
    }
}
