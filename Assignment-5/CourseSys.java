import java.util.*;
public class CourseSys
{
  public static void main(String args[])
  {
    String x;
    boolean l=true;
    int index=0;
    int choice;
    
    Scanner sc=new Scanner(System.in);
    ArrayList<String> list=new ArrayList<>();
    while(l==true)
    {
      System.out.println("\nChoose Operation: \n1. Add Course \n2.Remove Course \n3. View Registered Courses \n4.Exit \n");
      choice=sc.nextInt();
      switch (choice)
      {
        case 1:
            System.out.println("Enter Course to be added: \n");
            x=sc.next();
            list.add(x);
            break;
        
        case 2:
            System.out.println("Enter Course to be removed:\n");
            x=sc.next();
            if(list.contains(x))
            {
              index=list.indexOf(x);
              list.remove(index);
            }
            else
                System.out.println("Course not in list!! ");

            break;

        case 3:
            StringBuffer sb = new StringBuffer();
            for (String item : list) 
                {
                 sb.append(item).append(" ");
                }
            System.out.println(sb+"\n");

            break;
        
        case 4:
            l=false;
            break;

        
        default:
            System.out.println("Invalid Choice!!");
            break;
      }
      
    }
    
   sc.close();
  }
}