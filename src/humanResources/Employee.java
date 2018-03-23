package humanResources;

public class Employee {
    private String firstName;
    private String secondName;
    private String jobTitle;
    private int salary;
    private static final String JOB_TITLE = "";
    private static final int SALARY = 0;

    /*
    Конструкторы:
    - принимающий два параметра – имя и фамилию. Должность при этом инициализируется пустой строкой, а заработная плата – 0;
    - принимающий четыре параметра – имя, фамилия, должность и заработная плата.
    */
    //TODO конструктор с меньшим числом параметров вызывает конструктор с большим числом параметров
    //TODO значения по умолчанию в константы класса
    public Employee(String firstName, String secondName) {
        this(firstName, secondName, JOB_TITLE, SALARY);
    }

    public Employee(String firstName, String secondName, String jobTitle, int salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    /*
    Методы:
    - возвращающий имя.
    - устанавливающий новое значение имени.
    - возвращающий фамилию.
    - устанавливающий новое значение фамилии.
    - возвращающий должность.
    - устанавливающий новое значение должности.
    - возвращающий заработную плату.
    - устанавливающий новое значение заработной платы.
     */

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
