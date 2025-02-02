package geometry;

import edu.baykov.geometry.ClosedPolyline;
import edu.baykov.geometry.Point;
import edu.baykov.geometry.Polyline;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PolylineTest {
    @Test
    void equalsAndHashCode() {

        Point point1 = new Point(1, 2);
        Point point2 = new Point(3, 4);
        Point point3 = new Point(5, 6);
        Point point4 = new Point(7, 8);
        Polyline polyline1 = new Polyline(point1, point2, point3);
        Polyline polyline2 = new Polyline(point2, point3, point4, point1, point2);
        ClosedPolyline polyline3 = new ClosedPolyline(point3, point2, point1, point4);
        ClosedPolyline polyline4 = new ClosedPolyline(point1, point2, point3, point4);

        assertFalse(polyline1.equals(polyline2) && polyline2.equals(polyline1));
        assertTrue(polyline2.equals(polyline2) && polyline2.equals(polyline3) && polyline2.equals(polyline4));
        assertTrue(polyline3.equals(polyline3) && polyline3.equals(polyline2) && polyline3.equals(polyline4));
        assertTrue(polyline4.equals(polyline4) && polyline4.equals(polyline2) && polyline4.equals(polyline3));
        assertEquals(polyline2.hashCode(), polyline3.hashCode());
        assertEquals(polyline3.hashCode(), polyline4.hashCode());
        assertNotEquals(polyline1.hashCode(), polyline4.hashCode());


    }
}
