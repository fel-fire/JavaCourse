package oop;

/**
 * <p>Класс <b>Human</b> представляет реализацию объекта "человек",
 * которая описывается следующим образом:
 * <p>• name: полное имя (объект класса Name);</p>
 * <p>• height: рост (целое число);</p>
 * <p>• father: объект класса Human, являющийся отцом человека. </p></p>
 * <p>
 * @author   Nikolay Baykov
 * @version  1.1
 * @since    03-01-2025
 * @see Name
 */

public class Human {
    /**
     * Полное имя.
     */
    private Name name;
    /**
     * Рост.
     */
    private int height;
    /**
     * Отец.
     */
    final Human father;

    /**
     * Конструирует объект Human, принимая в качестве параметра полное имя, отца и рост:
     * @param name полное имя.
     * @param father объект класса Human, являющийся отцом человека.
     * @param height рост.
     */
    public Human(Name name, Human father, int height) {
        this.name = name;
        this.height = height;
        this.father = father;
    }
    /**
     * Конструирует объект Human, принимая в качестве параметра имя в формате строки, отца и рост:
     * @param name имя в строковом формате (создается объект Name с валидным firstName).
     * @param father объект класса Human, являющийся отцом человека.
     * @param height рост.
     */
    public Human(String name, Human father, int height) {
        this(new Name(name), father, height);
    }

    /**
     * Конструирует объект Human, принимая в качестве параметра имя в формате строки и рост:
     * @param name имя в строковом формате (создается объект Name с валидным firstName).
     * @param height рост.
     */
    public Human(String name, int height) {
        this(new Name(name), height);
    }
    /**
     * Конструирует объект Human, принимая в качестве параметра полное имя и рост:
     * @param name полное имя.
     * @param height рост.
     */
    public Human(Name name, int height) {
        this(name, null, height);
    }

    /**
     * Конструирует объект Human, принимая в качестве параметра имя в формате строки и отца:
     * @param name имя в строковом формате (создается объект Name с валидным firstName).
     * @param father объект класса Human, являющийся отцом человека.
     */
    public Human(String name, Human father) {
        this(new Name(name), father);
    }
    /**
     * Конструирует объект Human, принимая в качестве параметра полное имя и отца:
     * @param name полное имя.
     * @param father объект класса Human, являющийся отцом человека.
     */
    public Human(Name name, Human father) {
        this(name, father, 0);
    }

    /**
     * Конструирует объект Human, принимая в качестве параметра имя в формате строки:
     * @param name имя в строковом формате (создается объект Name с валидным firstName).
     */
    public Human(String name) {
        this(new Name(name));
    }
    /**
     * Конструирует объект Human, принимая в качестве параметра полное имя:
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
    public String getPatronimyc() {
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
     * Метод возвращает копию объекта father человека.
     * @return новый объект Human - копия father.
     */
    public Human getFather() {
        return new Human(father.getName(), father.getFather(), father.height);
    }
    /**
     * Метод возвращает полное имя человека.
     * @return полное имя.
     */
    private Name getName() {
        return new Name(name);
    }

    /**
     * Метод возвращает строковое представление объекта. В случае отсутствия у человека отчества и фамилии, получает их
     * от объекта father и т.д.
     * @return строковое представление объекта класса Human в виде "Фамилия Имя Отчество, рост: 000".
     */
    @Override
    public String toString() {
        if (father == null || father.getFirstName().isEmpty()) return String.format("%s, рост: %d", name, height);

        String result = getLastName() + " " + name;
        if (getPatronimyc().isEmpty()) result += " " + father.getFirstName() + "ович";
        return result.trim() + ", рост: " + height;
    }

}
