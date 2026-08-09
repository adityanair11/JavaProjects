
class Employee
{
    String name;
    int id;

    Employee(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    void display()
    {
        System.out.println("\nEmployee Name : " + name);
        System.out.println("Employee ID : " + id);
    }
}

class Manager extends Employee
{
    String department;

    Manager(String name, int id, String department)
    {
        super(name, id);
        this.department = department;
    }

    void display()
    {
        super.display();
        System.out.println("Department : " + department + "\n");
    }
}

public class EmployeeMain
{
    public static void main(String args[])
    {
        Manager obj= new Manager("Aditya Nair", 284, "Finance");
        obj.display();
    }
}