
interface Printable
{
    void print();
}

class Student implements Printable
{
    String name;
    int rollNo;

    Student(String name, int rollNo)
    {
        this.name = name;
        this.rollNo = rollNo;
    }

    public void print()
    {
        System.out.println("Student Name : " + name);
        System.out.println("Roll Number  : " + rollNo);
    }
}

class Employee implements Printable
{
    String name;
    int empId;

    Employee(String name, int empId)
    {
        this.name = name;
        this.empId = empId;
    }

    public void print()
    {
        System.out.println("Employee Name : " + name);
        System.out.println("Employee ID   : " + empId);
    }
}

public class PrintableDemo
{
    public static void main(String args[])
    {
        Student s = new Student("Aditya Nair", 284);
        Employee e = new Employee("Aryyan Paygude", 291);

        s.print();
        System.out.println();
        e.print();
    }
}