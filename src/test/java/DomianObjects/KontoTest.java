package DomianObjects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class KontoTest {

    Konto konto;

    @BeforeEach
    void setUp() {
        konto = new Konto("and","c00l",1,100,new TransaktionsListe(new ArrayList<>()));
    }

    @Test
    void indsæt() {
        assertEquals(200,konto.indsæt(100));
    }

    @Test
    void indsætNegativ() {
        assertEquals(100,konto.indsæt(-100));
    }

    @Test
    void hæv() {
        assertEquals(50,konto.hæv(50));
        assertEquals(50,konto.hæv(100));
    }

    @Test
    void hævNegativ() {
        assertEquals(100,konto.hæv(-100));
    }
}