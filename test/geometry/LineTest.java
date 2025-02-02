package geometry;

import edu.baykov.geometry.Line;
import edu.baykov.geometry.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LineTest {
    Line line;
    Point startPoint;
    Point endPoint;

    @BeforeEach
    void init() {
        startPoint = new Point(1, 2);
        endPoint = new Point(3, 4);
        line = new Line(startPoint, endPoint);
    }

    @Test
    void cloneTest() throws CloneNotSupportedException {

        Line newLine = line.clone();

        assertNotSame(line, newLine);
        assertNotSame(line.getStartPoint(), newLine.getStartPoint());
        assertNotSame(line.getEndPoint(), newLine.getEndPoint());
    }

    @Test
    void equalsAndHashCode() {
        Line line2 = new Line(1, 2, 3, 4);
        Line line3 = new Line(3, 4, 1, 2);

        assertTrue(line.hashCode() == line2.hashCode() && line.hashCode() == line3.hashCode());
        assertEquals(line, line2);
        assertEquals(line2, line);
        assertEquals(line, line3);
        assertEquals(line3, line);
        assertEquals(line2, line3);
        assertEquals(line3, line2);
    }
}
