package state;

import edu.baykov.state.Town;
import edu.baykov.state.Way;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WayTest {

    @Test
    void equalsAndHashCode() {
        Way ryazan = new Way(new Town("Ryazan"), 100);
        Way ryazan2 = new Way(new Town("Ryazan"), 300);
        Way voronezh = new Way(new Town("Voronezh"), 500);

        assertTrue(ryazan.equals(ryazan2) && ryazan2.equals(ryazan));
        assertFalse(ryazan.equals(voronezh) && ryazan2.equals(voronezh) &&
                voronezh.equals(ryazan) && voronezh.equals(ryazan2));
        assertEquals(ryazan.hashCode(), ryazan2.hashCode());

    }
}
