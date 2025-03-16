package database;

import edu.baykov.database.Database;
import edu.baykov.geometry.Point;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class DatabaseTest {

    @Test
    void dataBase() {

        Database database = new Database();
        database.respresentstors.put(Integer.class, (Function<Integer, String>) String::valueOf);
        database.respresentstors.put(String.class, (Function<String, String>) s -> s);
        database.respresentstors.put(Point.class, (Function<Point,String>) s -> "This is only some Point");
        database.extractors.put(Integer.class, Integer::parseInt);
        database.extractors.put(String.class, s -> s);
        database.extractors.put(Point.class, s -> new Point(0, 0));
        System.out.println(database);
        database.push("1");
        database.push(1);
        database.push(new Point(0, 0));


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
