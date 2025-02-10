package geometry;

import edu.baykov.geometry.Line;
import edu.baykov.geometry.Point;
import edu.baykov.geometry.Point3D;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LineTest {
    Line<Point> line;
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
        Line<Point> newLine = line.clone();

        assertNotSame(line, newLine);
        assertNotSame(line.getStart(), newLine.getStart());
        assertNotSame(line.getEnd(), newLine.getEnd());
    }

    @Test
    void cloneWithPoint3D() throws CloneNotSupportedException {
        Line<Point3D> line1 = new Line<>(new Point3D(2, 2, 2), new Point3D(3, 3, 3));
        Line<Point3D> line2 = line1.clone();

        assertNotSame(line1, line2);
        assertNotSame(line1.getStart(), line2.getStart());
        assertNotSame(line1.getEnd(), line2.getEnd());
    }

    @Test
    void equalsAndHashCode() {
        Line<Point> line2 = new Line<>(new Point(1,2),  new Point(3, 4));
        Line<Point> line3 = new Line<>(new Point(3, 4), new Point(1,2));

        assertTrue(line.hashCode() == line2.hashCode() && line.hashCode() == line3.hashCode());
        assertEquals(line, line2);
        assertEquals(line2, line);
        assertEquals(line, line3);
        assertEquals(line3, line);
        assertEquals(line2, line3);
        assertEquals(line3, line2);
    }
}
