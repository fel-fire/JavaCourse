package oop;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
/**
 * <p>Класс <b>Departament</b> представляет реализацию отдела в котором трудятся работники,
 * описывающийся следующим образом:
 * <p>• Название отдела: строка</p>
 * <p>• Начальник отдела: Employee</p>
 * <p>• Множество всех работников отдела</p></p>
 * <p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    04-01-2025
 * @see Employee
 */
public class Department {
    /**
     * Название отдела.
     */
    @Getter
    private String name;
    /**
     * Начальник отдела.
     */
    @Getter
    private Employee manager;
    /**
     * Список всех работников отдела.
     */
    private ArrayList<Employee> employees = new ArrayList<>();

    /**
     * Конструирует отдел из названия.
     * @param name название отдела.
     */
    public Department(String name) {
        this(name, null);
    }

    /**
     * Конструирует отдел из названия и начальника отдела.
     * @param name название отдела.
     * @param manager начальник отдела.
     * @throws IllegalArgumentException если название отдела пустое или null.
     */
    public Department(String name, Employee manager) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Название отдела не может быть пустым или null");
        this.name = name;
        this.manager = manager;
        if (manager != null) checkDepartamentValueAndAdd(manager);
    }

    /**
     * Метод, добавляющий работника в список работников, если указанный работник в списке отсутствует.
     * @param employee работник.
     */
    public void addEmployee(@NonNull Employee employee) {
        if (!employees.contains(employee))  {
            checkDepartamentValueAndAdd(employee);
        }
    }

    /**
     * Служебный метод, в случае перемещения работника из одного отдела в другой удаляющий работника
     * из прошлого списка, устанавливающий новое значение отдела работника и добавляющий работника в новый список.
     * @param employee работник.
     */
    private void checkDepartamentValueAndAdd(Employee employee) {
        employees.add(employee);
        if (!(employee.getDepartment().equals(this))) {
            employee.getDepartment().removeEmployee(employee);
            employee.getDepartment().setManager(null);
            employee.setDepartment(this);
        }
    }

    /**
     * Метод, удаляющий работника из списка работников
     * @param employee удаляемый работник
     */
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    /**
     * Метод, устанавливающий работника начальником отдела.
     * @param employee работник, назначаемый начальником.
     */
    public void setManager(Employee employee) {
        manager = employee;
        if (employee != null) addEmployee(employee);
    }

    /**
     * Метод, возвращающий строковое представление объекта.
     * @return строковое представление объекта Departament в виде:
     * "Отдел: 'название отдела'. 'имя начальника отдела' начальник отдела 'название отдела'"
     */
    @Override
    public String toString() {
        String outManager = "";
        if (manager != null) outManager = String.valueOf(manager);
        return "Отдел: " + name + ". " + outManager;
    }

    /**
     * Метод, возвращающий имя начальника отдела.
     * @return имя начальника отдела.
     */
    public String getManagerName() {
        return manager.getName();
    }

    /**
     * Метод, возвращающий в строковой форме список всех работников отдела.
     * @return строка, содержащая список всех работников отдела.
     */
    public String getEmployeesList() {
        String result = "";
        for (Employee e: employees) {
            result += e.getName() + "\n";
        }
        return result;
    }
}
