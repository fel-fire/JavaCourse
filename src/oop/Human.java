package oop;

import lombok.Getter;
import lombok.NonNull;

/**
 * <p>Класс <b>Human</b> представляет реализацию объекта "человек",
 * которая описывается следующим образом:
 * <p>• name: полное имя (объект класса Name);</p>
 * <p>• father: объект класса Human, являющийся отцом человека. </p></p>
 * <p>
 * @author   Nikolay Baykov
 * @version  1.1
 * @since    03-01-2025
 * @see Name
 */

@Getter
public class Human {
    /**
     * Полное имя.
     * -- GETTER --
     *  Метод возвращает полное имя человека.
     *
     * @return полное имя.

     */
    private Name name;
    /**
     * Отец.
     * -- GETTER --
     *  Метод возвращает копию объекта father человека.
     *
     * @return новый объект Human - копия father.

     */
    private final Human father;

    /**
     * Конструирует объект Human, принимая в качестве параметра полное имя, отца и рост:
     * @param name полное имя.
     * @param father объект класса Human, являющийся отцом человека.
     */
    public Human(@NonNull Name name, Human father) {
        this.name = name;
        this.father = father;
    }
    /**
     * Конструирует объект Human, принимая в качестве параметра имя в формате строки, отца и рост:
     * @param name имя в строковом формате (создается объект Name с валидным firstName).
     * @param father объект класса Human, являющийся отцом человека.
     */
    public Human(String name, Human father) {
        this(new Name(name), father);
    }

    /**
     * Конструирует объект Human, принимая в качестве параметра имя в формате строки и рост:
     * @param name имя в строковом формате (создается объект Name с валидным firstName).
     */
    public Human(String name) {
        this(new Name(name), null);
    }
    /**
     * Конструирует объект Human, принимая в качестве параметра полное имя и рост:
     * @param name полное имя.
     */
    public Human(Name name) {
        this(name, null);
    }

    /**
     * Метод возвращает имя человека.
     * @return имя.
     */
    public String getFirstName() {
        return name.getFirstName();
    }
    /**
     * Метод возвращает отчество человека.
     * @return отчество.
     */
    public String getPatronymic() {
        if (name.getPatronymic().isEmpty()) return father.getFirstName() + "ович";
        return name.getPatronymic();
    }
    /**
     * Метод возвращает фамилию человека. Если фамилия не указана, возвращает фамилию отца,
     * а в случае отсутствия фамилии у него - отца отца и т.д.
     * @return фамилия.
     */
    public String getLastName() {
        return name.getLastName() == null || name.getLastName().isEmpty() ? father.getLastName() : name.getLastName();
    }
    /**
     * Метод возвращает строковое представление объекта. В случае отсутствия у человека отчества и фамилии, получает их
     * от объекта father и т.д.
     * @return строковое представление объекта класса Human в виде "Фамилия Имя Отчество, рост: 000".
     */
    @Override
    public String toString() {
        if (father == null) return name.toString();
        String result = getLastName() + " " + getFirstName() + " " + getPatronymic();
        return result.trim();
    }

}
