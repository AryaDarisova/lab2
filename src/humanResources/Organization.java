package humanResources;

public class Organization {
    private String name;
    private Department[] departments;
    private int size = 0;
    private static final int SIZE = 8;

    /*
    Конструкторы: принимающий один параметр – называние организации.
    */

    public Organization(String name) {
        this(name, SIZE);
    }

    /*
    принимающий два параметра - назввние и количество департаментов
     */

    public Organization(String name, int size) {
        this.name = name;
        this.departments = new Department[size];
    }

    /*
    принимающий два параметра – название и массив департаментов.
    */

    public Organization(String name, Department[] departments) {
        this.name = name;
        System.arraycopy(departments, 0, this.departments, 0, SIZE);
    }

    /*
    Методы: добавления департамента в организацию. Принимает ссылку на экземпляр класса
    Department в качестве параметра.
    */

    public void add(Department department) {
        //TODO расширяй массив
        if (size >= departments.length) {
            Department[] departmentResize = new Department[size * 2];
            System.arraycopy(departments, 0, departmentResize, 0, departments.length);
            this.departments = departmentResize;
        }
        departments[size] = department;
        size++;
    }

    /*
    удаляющий департамент по его названию (принимает название в качестве параметра).
    */

    public void removeDepartment(String name) {
        for (int i = 0; i < size; i++) {
            if (departments[i].name().equals(name)) {
                for (int j = i + 1; j < size; j++) {
                    departments[i] = departments[j];
                }
                size--;
            }
        }
    }

    /*
    возвращающий ссылку на экземпляр класса Department по его названию (принимает
    название в качестве параметра).
    */

    public Department getDepartment(String name) {
        Department requiredDepartment = null;
        for (int i = 0; i < size; i++) {
            if (departments[i].name().equals(name)) {
                requiredDepartment = departments[i];
                return requiredDepartment;
            }
        }
        return requiredDepartment;
    }

    /*
    возвращающий массив отделов.
    */

    public Department[] getDepartments() {
        Department[] getDepartments = new Department[size];
        System.arraycopy(departments, 0, getDepartments, 0, size);
        //return departments; //todo копию созвращаешь, так же как в department
        return getDepartments;
    }

    /*
    возвращающий общее число отделов.
    */

    public int size() {
        return size;
    }

    /*
    возвращающий общее число сотрудников в организации.
    */

    public int employeesQuantity() {
        int employeesQuantity = 0;
        for (int i = 0; i < size; i++) {
            employeesQuantity += departments[i].size();
        }
        return employeesQuantity;
    }

    /*
    возвращающий количество сотрудников, занимающих заданную должность (должность
    передается в качестве параметра).
    */

    public int employeesQuantity(String jobTitle) {
        int employeesQuantity = 0;
        for (int i = 0; i < size; i++) {
            employeesQuantity += departments[i].employeesQuatityByJob(jobTitle);
        }
        return employeesQuantity;
    }

    /*
    возвращающий сотрудника с максимальной заработной платой в организации
    */

    public Employee bestEmployee() {
        Employee bestEmployee = null;
        bestEmployee = departments[0].getEmployees()[0];
        for (int i = 0; i < size; i++) {
            if (departments[i].bestEmployeeInDepartment().getSalary() > bestEmployee.getSalary()) {
                bestEmployee = departments[i].bestEmployeeInDepartment();
            }
        }
        return bestEmployee;
    }

    /*
    возвращающий ссылку на отдел в котором работает сотрудник. Имя и фамилия сотрудника
    передается в качестве параметра.
    */

    public Department getEmployeesDepartment(String firstName, String secondName) {
        Department getEmployeesDepartment = null;
        for (int i = 0; i < size; i++) {
            if (departments[i].hasEmployee(firstName, secondName)) {
                getEmployeesDepartment = departments[i];
            }
        }
        return getEmployeesDepartment;
    }
}
