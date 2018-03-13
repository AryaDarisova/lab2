package com.company;
import humanResources.*;

public class Main {

    public static void main(String[] args) {
        Employee worker1 = new Employee("Dan", "Black");
        System.out.println(worker1.getFirstName() + " " + worker1.getSecondName());

        Employee worker2 = new Employee("Walter", "White", "Designer", 500);
        System.out.println(worker2.getFirstName() + " " + worker2.getSecondName() + " " + worker2.getJobTitle() + " " + worker2.getSalary() + "$");
        worker2.setFirstName("Alex");
        worker2.setSalary(450);
        System.out.println("Corrected: " + worker2.getFirstName() + " " + worker2.getSecondName()
                + " " + worker2.getJobTitle() + " " + worker2.getSalary() + "$");

        Employee worker3 = new Employee("Dilan", "Red", "Lazy Person", 1);
        Employee worker4 = new Employee("Brian", "Welsh", "Security", 200);
        Employee worker5 = new Employee("Nora", "Vaar", "Director", 550);

        Department group = new Department("Lazy Penguins", 2);
        group.add(worker2);
        group.add(worker1);
        System.out.println("Add completed! Size of array: " + group.getEmployees().length);
        group.add(worker3);
        group.add(worker4);
        System.out.println("Add completed! Size of array: " + group.getEmployees().length);
        group.add(worker1);
        group.add(worker5);
        System.out.println("Elements in Array: " + group.size());

        System.out.println("\nNumber of employees in department before delete: " + group.size());

        group.remove("Dan", "Black");

        System.out.println("Number of employees in department after delete: " + group.size());

        for (int i = 0; i < group.size(); i++) {
            System.out.println("Employee[" + (i + 1) + "]: " + group.getEmployees()[i].getFirstName() + " " + group.getEmployees()[i].getSecondName() +
                    " " + group.getEmployees()[i].getJobTitle() + " " + group.getEmployees()[i].getSalary());
        }

        System.out.print("Director: ");
        for (int i = 0; i < group.getEmployees("Director").length; i++) {
            System.out.println(group.getEmployees("Director")[i].getFirstName() + " " + group.getEmployees("Director")[i].getSecondName());
        }

        System.out.println("Sorted by Salary: ");
        group.employeesSortedBySalary();
        for (int i = 0; i < group.size(); i++) {
            System.out.println("Employee[" + (i + 1) + "]: " + group.getEmployees()[i].getFirstName() + " " + group.getEmployees()[i].getSecondName() +
                    " " + group.getEmployees()[i].getJobTitle() + " " + group.getEmployees()[i].getSalary());
        }

        Organization organization = new Organization("Organization of Penguins");
        Department group2 = new Department("Royal Penguins", 4);
        group2.add(worker3);
        group2.add(worker4);


        organization.add(group);
        organization.add(group2);
        organization.removeDepartment("Royal Penguins");
        System.out.println("\nCount of departments after delete: " + organization.size());

        organization.add(group2);

        System.out.println("\nNumber of employees in the Organization: " +organization.employeesQuantity());
        System.out.println("\nNumber of directors in the Organization: " +organization.employeesQuantity("Director"));
        System.out.println();

        for (int i = 0; i < organization.size(); i++)
            System.out.println("Name of department " + (i + 1) + ": " + organization.getDepartments()[i].name());

        System.out.println("\nCount of departments in Organization: " + organization.size());
        System.out.println("\nCount of employees in department 'Royal Penguins': " + organization.getDepartment("Royal Penguins").size());

        System.out.println("\nDilan Red work in department: " + organization.getEmployeesDepartment("Dilan", "Red").name());

        System.out.println("\nName of Best Employee: " + organization.bestEmployee().getFirstName() + " " + organization.bestEmployee().getSecondName());
    }
}

