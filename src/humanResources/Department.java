package humanResources;

public class Department {
    private String name;
    private Employee[] employees;
    private static final int SIZE_DEFAULT = 8;
    private int size = 0;

    /*
    Конструкторы:
    - принимающий один параметр – название отдела, инициирующий массив из 8 элементов (сами элементы имеют значение null).
     */

    public Department(String name) {
        this(name,SIZE_DEFAULT);
    }

    /*
    - принимающий название и целое число – емкость массива, инициирующий массив указанным числом элементов (сами элементы имеют значение null).
     */

    public Department(String name, int size) {
        this.name = name;
        this.employees = new Employee[size];
    }

    /*
    - принимающий название отдела и массив сотрудников.
     */

    public Department(String name, Employee[] employees) {
        this.name = name;
        System.arraycopy(employees, 0, this.employees, 0, SIZE_DEFAULT);
    }

    /*
    Методы:
    - добавляющий сотрудника в отдел (принимает ссылку на экземпляр класса Employee).

    Емкость – это размер массива. Число элементов – это текущее число элементов, имеющих
    ссылки на экземпляр класса Employee (их может быть меньше, чем размер массива).
    */

    public void add(Employee employee) {
        if (size >= employees.length) {
            Employee[] employeesResize = new Employee[size * 2];
            System.arraycopy(employees, 0, employeesResize, 0, employees.length);
            this.employees = employeesResize;
        }
        employees[size] = employee;
        size++;
    }

    /*
    - увольнения сотрудника по его имени и фамилии (принимает 2 параметра – имя и фамилию).
    Возвращает логическое значение (true, если элемент был удален).

    При удалении заказа емкость массива не меняется. Все элементы с 0-го до удаляемого (не
    включительно) остаются без изменений. А элементы, начиная со следующего, после удаляемого,
    копируются в предыдущий элемент. Последний, имеющий значение не null после копирования
    заменяется значением null.
    */

    public boolean remove(String firstName, String secondName) {
        boolean remove = false;
        for (int j = 0; j < size; j++) {
            if ((employees[j].getFirstName().equals(firstName)) & (employees[j].getSecondName().equals(secondName))) {
                for (int i = j + 1; i < size; i++) {
                    employees[j] = employees[i];
                }
                size--;
                remove = true;
            }
        }
        return remove;
    }

    /*
    - возвращающий общее число сотрудников в отделе.
    */

    public int size() {
        return size;
    }

    /*
    - возвращает название отдела
     */

    public String name() {
        return name;
    }

    /*
    - возвращающий массив сотрудников (значений null в массиве быть не должно).
    */

    public Employee[] getEmployees() {
        Employee[] employeesInArray = new Employee[size];
        System.arraycopy(employees, 0, employeesInArray, 0, size);
        return employeesInArray;
    }

    /*
    - возвращающий массив сотрудников, занимающих заданную должность (должность
    передается в качестве параметра)
    */

    public Employee[] getEmployees(String jobTitle) {
        int peopleByJob = 0;
        for (int i = 0; i < size; i++) {
            if (getEmployees()[i].getJobTitle().equals(jobTitle)) {
                peopleByJob++;
            }
        }
        Employee[] employeesByJobTitle = new Employee[peopleByJob];
        for (int j = 0, k = 0; j < size; j++) {
            if (getEmployees()[j].getJobTitle().equals(jobTitle)) {
                employeesByJobTitle[k] = getEmployees()[j];
                k++;
            }
        }
        return employeesByJobTitle;
    }

    /*
    -  возвращающий массив сотрудников, отсортированный по убыванию заработной платы.
    */

    public Employee[] employeesSortedBySalary() {
        Employee[] employeesSortedBySalary = new Employee[getEmployees().length];
        System.arraycopy(getEmployees(), 0, employeesSortedBySalary, 0, getEmployees().length);
        for (int i = employeesSortedBySalary.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (employeesSortedBySalary[j].getSalary() < employeesSortedBySalary[j + 1].getSalary()) {
                    Employee replace = employeesSortedBySalary[j];
                    employeesSortedBySalary[j] = employeesSortedBySalary[j + 1];
                    employeesSortedBySalary[j + 1] = replace;
                }
            }
        }
        return employeesSortedBySalary;
    }

    /*
    Метод, возвращающий количство сотрудников с заданной должностью
     */

    public int employeesQuatityByJob (String jobTitle) {
        int employeesQuantity = 0;
        for (int i = 0; i < size; i++) {
            if (getEmployees()[i].getJobTitle().equals(jobTitle)) {
                employeesQuantity++;
            }
        }
        return employeesQuantity;
    }

    /*
    Метод, возвращающий лучшего работника
     */

    public Employee bestEmployeeInDepartment() {
        Employee bestEmployeeInDepartment = null;
        bestEmployeeInDepartment = getEmployees()[0];
        for (int i = 0; i < size; i++) {
            if (getEmployees()[i].getSalary() > bestEmployeeInDepartment.getSalary()) {
                bestEmployeeInDepartment = getEmployees()[i];
            }
        }
        return bestEmployeeInDepartment;
    }

    /*
    Метод, определяющий наличие сотрудника в отделе
     */

    public boolean hasEmployee(String firstName, String secondName) {
        boolean hasEmployee = false;
        for (int i = 0; i < size; i++) {
            if (getEmployees()[i].getFirstName().equals(firstName) & getEmployees()[i].getSecondName().equals(secondName)) {
                hasEmployee = true;
                return hasEmployee;
            }
        }
        return hasEmployee;
    }
}