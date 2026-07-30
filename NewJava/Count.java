import java.util.*;
public class Count
{
    public static void main(String args[])
    {
        String newstr;
        int c=0;
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter a sentance: ");
       String s=sc.nextLine();
       newstr=s.trim();
       for(int i=0; i<newstr.length(); i++)
       {
        
        if(newstr.charAt(i)==' ')
            c++;
       }
       c++;
       System.out.println("No. of words: "+c);


    }
}
