package fraction;

import edu.baykov.fraction.Fraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {
    Fraction fraction;

    @BeforeEach
    void init() {
        fraction = Fraction.of(4, 10);
    }

    @Test
    void cloneTest() throws CloneNotSupportedException {
        Fraction newFraction = fraction.clone();
        //assertNotSame(fraction, newFraction);
        assertSame(fraction, newFraction);
        assertEquals(fraction.getDenominator(), newFraction.getDenominator());
        assertEquals(fraction.getNumerator(), newFraction.getNumerator());
    }

    @Test
    void equalsAndHashCode() throws CloneNotSupportedException {
        Fraction newFraction1 = Fraction.of(4, 10);
        Fraction newFraction2 = Fraction.of(4, 10);
        Fraction newFraction3 = Fraction.of(10, 4);

        assertEquals(fraction.hashCode(), newFraction1.hashCode());
        assertEquals(fraction, fraction);
        assertEquals(fraction, newFraction1);
        assertEquals(newFraction1, fraction);
        assertEquals(newFraction1, newFraction2);
        assertEquals(newFraction2, fraction);
        assertNotEquals(fraction, newFraction3);
    }

}
