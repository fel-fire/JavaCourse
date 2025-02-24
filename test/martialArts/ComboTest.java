package martialArts;

import edu.baykov.martialArts.*;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ComboTest {

    @Test
    @Order(1)
    void makeCombo() {
        Karatist kar = new Karatist("Daniel");
        ConcreteCombo combo1 = new ConcreteCombo();
        combo1.addActInCombo(Fighter::hit);
        combo1.addActInCombo(Fighter::kick);
        combo1.addActInCombo(Fighter::hitInJump);
        combo1.makeCombo(kar);
        System.out.println("=======================");
        combo1.addActInCombo(Fighter::kick);
        combo1.addActInCombo(Fighter::hitInJump);
        combo1.makeCombo(kar);
        System.out.println("=======================");
    }

    @Test
    @Order(2)
    void makeComboWithGenerator() {
        Karatist kar = new Karatist("Daniel");
        Fighter kar2 = new Karatist("Sidor");
        Combo combo2 = new ComboGenerator().generateCombo(5);
        combo2.makeCombo(kar);
        combo2.makeCombo(kar2);
    }
}
