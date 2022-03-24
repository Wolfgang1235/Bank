package DomianObjects;

import java.util.ArrayList;

public class TransaktionsListe {
    private ArrayList<TransaktionsObjekt> transaktionsObjekts;

    public TransaktionsListe(ArrayList<TransaktionsObjekt> transaktionsObjekts) {
        this.transaktionsObjekts = transaktionsObjekts;
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
