package student;

import edu.baykov.student.Student;
import edu.baykov.student.StudentOneOrZero;
import edu.baykov.student.StudentOnlyEven;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentTest {

    @Test
    @Order(1)
    void addMark() {
        Student student = new Student("X");
        int[] marks = {15, 132, 134, 51, 60, 51, 10, 70};
        int start = student.getMarks().size();

        assertDoesNotThrow(() -> student.addMark(marks));
        List<Integer> testList = student.getMarks();

        for (int i = start; i < testList.size(); i++) {
            assertEquals(marks[i], testList.get(i));
        }
    }

    @Test
    @Order(2)
    void addMarkOneOrZero() {
        Student student = new Student("X", new StudentOneOrZero());
        int[] marks = {1, 1, 1, 1, 0, 1, 0, 0};
        int start = student.getMarks().size();

        assertDoesNotThrow(() -> student.addMark(marks));
        List<Integer> testList = student.getMarks();

        for (int i = start; i < testList.size(); i++) {
            assertEquals(marks[i], testList.get(i));
        }

    }
    @Test
    @Order(3)
    void addMarkOnlyEven() {
        Student student = new Student("X", new StudentOnlyEven());
        int[] marks = {2, 4, 6, 8, 6, 4, 2, 10};
        int start = student.getMarks().size();

        assertDoesNotThrow(() -> student.addMark(marks));
        List<Integer> testList = student.getMarks();

        for (int i = start; i < testList.size(); i++) {
            assertEquals(marks[i], testList.get(i));
        }
    }

    @Test
    void averageMark() {
        Student student = new Student("X", new StudentOnlyEven(), 2, 4, 6, 8);
        Student student2 = new Student("X", new StudentOneOrZero(), 1, 1, 1, 1, 0, 0, 0, 0);

        assertEquals(5, student.averageMark());
        assertEquals(0.5, student2.averageMark());
    }

    @Test
    void equalsAndHashCode() {
        Student student1 = new Student("Arkadiy", 2, 5, 4, 3, 4, 5);
        Student student2 = new Student("Arkadiy", 3, 4, 4, 4, 4, 4);
        Student student3 = new Student("Petr", 3, 2, 2, 2, 2, 2);

        assertTrue(student1.equals(student2) && student2.equals(student1));
        assertFalse(student3.equals(student2) && student3.equals(student1));
        assertEquals(student1.hashCode(), student2.hashCode());
    }

    @Test
    void toCompare() {
        Student student1 = new Student("Arkadiy", 5, 5, 4, 3, 4, 5);
        Student student2 = new Student("Vasiliy", 4, 4, 4, 4, 4, 4);
        Student student3 = new Student("Petr", 5, 5, 4, 3, 4, 5);

        assertEquals(1, student1.compareTo(student2));
        assertEquals(-1, student2.compareTo(student3));
        assertEquals(0, student1.compareTo(student3));
    }
}
