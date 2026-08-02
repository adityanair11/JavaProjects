import java.util.Scanner;

public class Assignment4 
{

    //Exercise 1-Student Marks
    static void studentMarks() 
    {
        System.out.println("\nStudent: Aditya Nair");
        String s1="92";
        String s2="93";
        String s3="94";
        int mark1=Integer.parseInt(s1);
        int mark2=Integer.parseInt(s2);
        int mark3=Integer.parseInt(s3);
        int total=mark1+mark2+mark3;
        System.out.println("Total marks: " + total);
    }

    //Exercise 2-Employee Payroll
    static void employeePayroll() 
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\nEnter employee ID: ");
        String id=sc.nextLine();
        
        System.out.println("Enter employee salary: ");
        String salaryInput=sc.nextLine();
        
        System.out.println("Enter employee bonus: ");
        String bonusInput=sc.nextLine();
        
        // Converting String input to wrapper objects
        Double salary = Double.parseDouble(salaryInput);
        Double bonus = Double.parseDouble(bonusInput);
        
        //validation for negative salary and bonus
        if(salary< 0)
        {
            System.out.println("Invalid salary");
            System.exit(0);
        }
        if(bonus< 0)
        {
            System.out.println("Invalid bonus");
            System.exit(0);
        }
        
        Double totalSalary=salary+bonus;
        
        System.out.println("Employee ID: " + id);
        System.out.println("Basic Salary: " + salary);
        System.out.println("Bonus: " + bonus);
        System.out.println("Total Salary: " + totalSalary);

        
        sc.close();
    }

    public static void main(String[] args) {
        studentMarks();
        employeePayroll();
    }
}