package DomianObjects;

import java.util.ArrayList;

public class BrugerListe {
    private ArrayList<String> brugere;

    public BrugerListe(ArrayList<String> brugere) {
        this.brugere = brugere;
    }

    public void addToBrugerList(String navn) {
        brugere.add(navn);
    }

    public boolean checkBrugerInList(String navn) {
        if (brugere.contains(navn)) {
            return true;
        }
        return false;
    }
}
