package oop;

import lombok.Getter;
import lombok.NonNull;

/**
 * <p>Класс <b>Employee</b> представляет реализацию работника,
 * который описывается следующим образом:
 * <p>•Имя работника: строка</p>
 * <p>•Отдел, в котором работник трудится: Departament</p></p>
 * <p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    04-01-2025
 * @see Department
 */
@Getter
public class Employee {
    /**
     * Имя работника.
     */
    private final String name;
    /**
     * Отдел.
     */
    private Department department;

    /**
     * Конструирует объект Employee из имени и отдела. Одновременно добавляет работника в список работников
     * данного отдела в классе Departament.
     * @param name имя работника.
     * @param department отдел.
     */
    public Employee(@NonNull String name, @NonNull Department department) {
        this.name = name;
        this.department = department;
        department.addEmployee(this);
    }

    /**
     * Метод, устанавливающий новое значение отдела работнику, одновременно включает его в новый список отдела
     * и удаляет из старого.
     * @param department - новое значение отдела.
     */
    public void setDepartment(@NonNull Department department) {
        department.addEmployee(this);
        this.department = department;
    }

    /**
     * Метод, возвращающий строковое представление объекта.
     * @return <p>"Это не наш сотрудник" - если сотрудник не имеет отдела,</p>
     *         <p>"'name' начальник отдела 'departament' - если сотрудник является начальником отдела,</p>
     *         <p>в остальных случаях "'name' работает в отделе 'departament', начальник которого 'name'.</p>
     */
    @Override
    public String toString() {
        if (department == null ||
                department.getName() == null ||
                    department.getName().isEmpty()) return "Это не наш сотрудник";
        if (department.getManager() == null) return String.format("%s работает в отделе %s", name, department.getName());
        if (department.getManager() == this) return String.format("%s начальник отдела %s", name, department.getName());
        return String.format("%s работает в отделе %s, начальник которого %s",
                                    name, department.getName(), department.getManagerName());
    }
}
