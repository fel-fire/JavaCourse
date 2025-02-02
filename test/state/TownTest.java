package state;

import edu.baykov.state.Town;
import edu.baykov.state.TownWithBackWay;
import edu.baykov.state.Way;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TownTest {
    @Test
    void equalsAndHashCode() {

        Town moscow = new Town("Moscow");
        TownWithBackWay vladimir = new TownWithBackWay("Vladimir");
        Town townTo1 = new Town("Ryazan");
        Town townTo2 = new Town("Smolensk");
        Town townTo3 = new Town("Voronezh");
        moscow.addWay(new Way(townTo1, 100), new Way(townTo2, 300), new Way(townTo3, 500));
        vladimir.addWay(new Way(townTo1, 1000), new Way(townTo3, 5000), new Way(townTo2, 3000));

        assertEquals(moscow, vladimir);
        assertEquals(moscow.hashCode(), vladimir.hashCode());
        assertNotEquals(moscow, townTo1);
        assertNotEquals(moscow, townTo2);
        assertNotEquals(moscow, townTo3);
        assertNotEquals(vladimir, townTo1);
        assertNotEquals(vladimir, townTo2);
        assertNotEquals(vladimir, townTo3);

    }
}
