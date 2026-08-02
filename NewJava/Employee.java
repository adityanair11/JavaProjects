import java.util.*;
public class Employee 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter employee ID: ");
        String id=sc.nextLine();
        System.out.print("Enter employee salary: ");
        double salary=sc.nextDouble();
        if(salary<0)
        {
            System.out.println("Invalid salary");
            System.exit(0);
        }
        System.out.print("Enter employee bonus salary: ");
        double bsalary=sc.nextDouble();
        if(bsalary<0)
        {
            System.out.println("Invalid salary");
            System.exit(0);
        }
        double totalSalary=salary+bsalary;
        
        System.out.println("Employee ID: " + id);
        System.out.println("Total salary: " + totalSalary);
        sc.close();
    }
    
}
