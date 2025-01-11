package oop;

import lombok.Getter;

/**
 * <p>Класс <b>Name</b> представляет реализацию сочетания фамилии, имени и отчества человека,
 * которая описывается следующим образом:
 * <p>• firstName: имя;</p>
 * <p>• lastName: фамилия;</p>
 * <p>• patronymic: отчество. </p></p>
 * <p>
 * @author   Nikolay Baykov
 * @version  1.1
 * @since    03-01-2025
 */

@Getter
public class Name {
    /**
     * Имя.
     */
    private final String firstName;
    /**
     * Фамилия.
     */
    private final String lastName;
    /**
     * Отчество.
     */
    private final String patronymic;

    /**
     * Конструирует объект класса Name из имени, фамилии и отчества. Наличие валидного firstName обязательно.
     * @param firstName имя человека, не может отсутствовать.
     * @param lastName фамилия человека, в случае отсутствия принимает пустое значение.
     * @param patronymic отчество человека, в случае отсутствия принимает пустое значение.
     * @throws IllegalArgumentException если имя человека пустое или null.
     */
    public Name(String firstName, String lastName, String patronymic) {
        if (firstName == null || firstName.isEmpty())
            throw new IllegalArgumentException("A firstName must not be empty or NULL.");

        this.firstName = firstName;
        this.lastName = lastName == null ? "" : lastName;
        this.patronymic = patronymic == null ? "" : patronymic;
    }
    /**
     * Конструирует объект класса Name из имени. Наличие валидного firstName обязательно.
     * @param firstName имя человека, не может отсутствовать или быть null.
     */
    public Name(String firstName) {
        this(firstName, "", "");
    }
    /**
     * Конструирует объект класса Name из имени и фамилии. Наличие валидного firstName обязательно.
     * @param firstName имя человека, не может отсутствовать или быть null.
     */
    public Name(String firstName, String lastName) {
        this(firstName, lastName, "");
    }

    /**
     * Копирующий конструктор.
     * @param name объект, копию которого необходимо создать.
     */
    Name(Name name) {
       this(name.getFirstName(), name.getLastName(), name.getPatronymic());
    }
    /**
     * Метод возвращает строковое представление объекта
     * @return строковое представление объекта класса Name в виде "Фамилия Имя Отчество".
     */
    @Override
    public String toString() {
        return String.format("%s %s %s", lastName, firstName, patronymic).trim();
    }


}
