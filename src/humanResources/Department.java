package humanResources;

public class Department {
    private String name;
    private Employee[] employees;
    private static final int SIZE_DEFAULT = 8;
    private int elInArray = 0;

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
        if (elInArray >= employees.length) {
            Employee[] employeesResize = new Employee[elInArray * 2];
            System.arraycopy(employees, 0, employeesResize, 0, employees.length);
            this.employees = employeesResize;
            employeesResize[elInArray] = employee;
        }
        else for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
        elInArray++;
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
        int removeItems = 0, difference = 0;
        int[] num = new int[elInArray];
        for (int i = 0; i < elInArray; i++) {
            if ((employees[i].getFirstName().equals(firstName)) & (employees[i].getSecondName().equals(secondName))) {
                num[removeItems] = i;
                removeItems++;
            }
        }
        num[removeItems] = elInArray;
        for (int j = 0; j < removeItems; j++) {
            System.arraycopy(employees, num[j] + 1, employees, num[j] - difference, num[j + 1] - num[j] - 1);
            difference++;
            remove = true;
        }
        elInArray -= removeItems;
        return remove;
    }

    /*
    - возвращающий общее число сотрудников в отделе.
    */

    public int size() {
        return elInArray;
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
        Employee[] employeesInArray = new Employee[elInArray];
        System.arraycopy(employees, 0, employeesInArray, 0, elInArray);
        return employeesInArray;
    }

    /*
    - возвращающий массив сотрудников, занимающих заданную должность (должность
    передается в качестве параметра)
    */

    public Employee[] getEmployees(String jobTitle) {
        int peopleByJob = 0;
        for (int i = 0; i < elInArray; i++) {
            if (employees[i].getJobTitle().equals(jobTitle)) {
                peopleByJob++;
            }
        }
        Employee[] employeesByJobTitle = new Employee[peopleByJob];
        for (int j = 0; j < elInArray; j++) {
            if (employees[j].getJobTitle().equals(jobTitle)) {
                for (int k = 0; k < peopleByJob; k++) {
                    if (employeesByJobTitle[k] == null) {
                        employeesByJobTitle[k] = employees[j];
                        break;
                    }
                }
            }
        }
        return employeesByJobTitle;
    }

    /*
    -  возвращающий массив сотрудников, отсортированный по убыванию заработной платы.
    */

    public Employee[] employeesSortedBySalary() {
        for (int i = elInArray - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (employees[j].getSalary() < employees[j + 1].getSalary()) {
                    Employee replace = employees[j];
                    employees[j] = employees[j + 1];
                    employees[j + 1] = replace;
                }
            }
        }
        return employees;
    }
}
