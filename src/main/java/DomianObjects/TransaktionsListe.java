package DomianObjects;

import java.util.ArrayList;
import java.util.List;

public class TransaktionsListe {
    private ArrayList<TransaktionsObjekt> transaktionsObjekts;

    public TransaktionsListe(ArrayList<TransaktionsObjekt> transaktionsObjekts) {
        this.transaktionsObjekts = transaktionsObjekts;
    }

    public ArrayList<TransaktionsObjekt> getTransaktionsObjekts() {
        return transaktionsObjekts;
    }

    public void addToList(TransaktionsObjekt transaktionsObjekt) {
        transaktionsObjekts.add(transaktionsObjekt);
    }

    @Override
    public String toString() {
        String res = "";

        for (TransaktionsObjekt transaktionsObjekt : transaktionsObjekts) {
            res += transaktionsObjekt.toString() + " ";
        }

        return res;
    }
}
