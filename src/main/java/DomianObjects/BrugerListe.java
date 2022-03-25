package DomianObjects;

import java.util.ArrayList;

public class BrugerListe {
    private ArrayList<Integer> brugere;

    public BrugerListe(ArrayList<Integer> brugere) {
        this.brugere = brugere;
    }

    public void addToBrugerList(Integer kontonummer) {
        brugere.add(kontonummer);
    }

    public boolean checkBrugerInList(Integer kontonummer) {
        if (brugere.contains(kontonummer)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String res = "";

        for (Integer i : brugere) {
            res += i + " ";
        }
        return res;
    }
}
