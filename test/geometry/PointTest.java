package geometry;

import edu.baykov.geometry.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PointTest {
    Point point;

    @BeforeEach
    void init() {
        point = new Point(4, 10);
    }

    @Test
    void cloneTest() throws CloneNotSupportedException {

        Point newPoint = point.clone();
        int testX = newPoint.getX();
        int testY = newPoint.getY();
        newPoint.setX(testX + 10);
        newPoint.setY(testY + 10);

        assertNotSame(point, newPoint);
        assertEquals(point.getX(), testX);
        assertEquals(point.getY(), testY);
        assertNotEquals(point.getX(), newPoint.getX());
        assertNotEquals(point.getY(), newPoint.getY());
    }

    @Test
    void equalsAndHashCode() {
        Point newPoint = new Point(4, 10);
        Point newPoint2 = new Point(10, 4);

        assertEquals(point.hashCode(), newPoint.hashCode());
        assertTrue(point.equals(newPoint));
        assertFalse(point.equals(newPoint2));
    }
}

