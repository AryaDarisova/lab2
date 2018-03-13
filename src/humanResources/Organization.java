package humanResources;

public class Organization {
    private String name;
    private Department[] departments;
    private int countDepartments = 0;

    /*
    Конструкторы: принимающий один параметр – называние организации.
    */

    public Organization(String name) {
        this.name = name;
        Department[] departments = new Department[8];
        this.departments = departments;
    }

    /*
    принимающий два параметра – название и массив департаментов.
    */

    public Organization(String name, Department[] departments) {
        this.name = name;
        System.arraycopy(departments, 0, this.departments, 0, 8);
    }

    /*
    Методы: добавления департамента в организацию. Принимает ссылку на экземпляр класса
    Department в качестве параметра.
    */

    public void add(Department department) {
        departments[countDepartments] = department;
        countDepartments++;
    }

    /*
    удаляющий департамент по его названию (принимает название в качестве параметра).
    */

    public void removeDepartment(String name) {
        for (int i = 0; i < countDepartments; i++) {
            if (departments[i].name().equals(name)) {
                if (i == countDepartments) {
                    departments[countDepartments] = null;
                    countDepartments--;
                }
                System.arraycopy(departments, i+1, departments, i, countDepartments - i - 1);
                departments[countDepartments - 1] = null;
                countDepartments--;
            }
        }
    }

    /*
    возвращающий ссылку на экземпляр класса Department по его названию (принимает
    название в качестве параметра).
    */

    public Department getDepartment(String name) {
        Department requiredDepartment = new Department("tmp");
        for (int i = 0; i < countDepartments; i++) {
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
        return departments;
    }

    /*
    возвращающий общее число отделов.
    */

    public int size() {
        return countDepartments;
    }

    /*
    возвращающий общее число сотрудников в организации.
    */

    public int employeesQuantity() {
        int employeesInOrganization = 0;
        for (int i = 0; i < countDepartments; i++) {
            employeesInOrganization += departments[i].size();
        }
        return employeesInOrganization;
    }

    /*
    возвращающий количество сотрудников, занимающих заданную должность (должность
    передается в качестве параметра).
    */

    public int employeesQuantity(String jobTitle) {
        int employeesByJob = 0;
        for (int i = 0; i < countDepartments; i++) {
            for (int j = 0; j < departments[i].size(); j++) {
                if (departments[i].getEmployees()[j].getJobTitle().equals(jobTitle))
                employeesByJob++;
            }
        }
        return employeesByJob;
    }

    /*
    возвращающий сотрудника с максимальной заработной платой в организации
    */

    public Employee bestEmployee() {
        Employee employeeWithBestSalary = new Employee("tmp", "tmp");
        employeeWithBestSalary = departments[0].getEmployees()[0];
        for (int i = 0; i < countDepartments; i++) {
            for (int j = 0; j < departments[i].size(); j++) {
                if (departments[i].getEmployees()[j].getSalary() > employeeWithBestSalary.getSalary())
                    employeeWithBestSalary = departments[i].getEmployees()[j];
            }
        }
        return employeeWithBestSalary;
    }

    /*
    возвращающий ссылку на отдел в котором работает сотрудник. Имя и фамилия сотрудника
    передается в качестве параметра.
    */

    public Department getEmployeesDepartment(String firstName, String secondName) {
        Department employeesDepartment= new Department("tmp");
        for (int i = 0; i < countDepartments; i++) {
            for (int j = 0; j < departments[i].size(); j++) {
                if (departments[i].getEmployees()[j].getFirstName().equals(firstName) & departments[i].getEmployees()[j].getSecondName().equals(secondName))
                    employeesDepartment = departments[i];
            }
        }
        return employeesDepartment;
    }
}
