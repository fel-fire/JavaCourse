package database;

import edu.baykov.database.Database;
import edu.baykov.geometry.Point;
import org.junit.jupiter.api.Test;

public class DatabaseTest {

    @Test
    void dataBase() {

        Database database = new Database();
        database.push(1, obj -> "1", obj -> 1);
        database.push(2, obj -> "TWO", obj -> 2);
        database.push(new Point(1,3), obj -> "Point with coordinates 1, 3", obj -> new Point(1,3));
        System.out.println(database);

        String s = database.get(0, String.class);
        System.out.println(s.getClass() + " " + s);

        Integer i = database.get(0, Integer.class);
        System.out.println(i.getClass() + " " + i);

        s = database.get(2, String.class);
        System.out.println(s.getClass() + " " + s);

        Point point = database.get(2, Point.class);
        System.out.println(point.getClass() + " " + point);

        // i = database.get(2, Integer.class);
        //System.out.println(i.getClass() + " " + i);
    }
}
