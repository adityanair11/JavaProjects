public class Pattern1 
{
    void p1(int r)
    {
        int rows=r-2;
        System.out.println("\n* * * * *");
        for(int i=0;i<rows;i++)
        {
          System.out.println("*       *");  
        }
        System.out.println("* * * * *\n");
    }

    void p2(int r)
    {
        int rows=r;
        int n=1;
        for(int i=1;i<=rows;i++)
        {
          for(int j=rows;j>=i;j--)
         {
          System.out.print(" ");  
         }
         for(int k=1;k<=i;k++)
         {
          System.out.print(n+" ");
         }
         n++;
         System.out.println();
        }
        
    }

    void p3(int r)
    {
        int rows=r;
        int n=1;
        for(int i=1;i<=rows;i++)
        {
         for(int k=1;k<=i;k++)
         {
          System.out.print(k+" ");
         }
         n++;
         System.out.println();
        }
    }

    void p4(int r)
    {
        int rows=r;
        int n=1;
        for(int i=1;i<=rows;i++)
        {
         for(int k=rows-i+1;k>=1;k--)
         {
          System.out.print(n+" ");
          n++;
         }
         n=1;
         System.out.println();
        }
    }

    void p5(int r)
    {
        int rows=r;
        int n=1;
        for(int i=1;i<=rows;i++)
        {
         for(int k=1;k<=i;k++)
         {
          System.out.print(n+" ");
          n++;
         }
         System.out.println();
        }
    }

    void p6(int r)
    {
        int rows=r;
        int n=1;
        for(int i=1;i<=rows;i++)
        {
         for(int k=1;k<=i;k++)
         {
          System.out.print(n+" ");
          n++;
         }
         System.out.println();
        }
    }

    void diamond(int r)
    {
        int rows=r;
        int n=1;
        
        for(int i=1;i<=rows;i++)//upper hald
        {
         for(int k=i;k<=rows;k++)
         {
          System.out.print(" ");
         }
         for(int k=1;k<=i;k++)
         {
          System.out.print("* ");
         }
         System.out.println();
        }

        for(int i=1;i<=rows-1;i++)//lowe half
        {
         for(int k=0;k<=i;k++)
         {
          System.out.print(" ");
         }
         for(int k=rows+i;k<=(rows*2)-1;k++)
         {
          System.out.print("* ");
         }
         System.out.println();
        }
        
    }

    void rhombus(int r)
    {
        int rows=r;
        for(int i=1;i<=rows;i++)//lowe half
        {
            for(int k=0;k<=i;k++)
         {
          System.out.print(" ");
         }
        }
    }

    void palintriangle(int r)
    {
        int rows=r;
        for(int i=1;i<=rows;i++)
        {
          for(int j=rows;j>=i;j--)
          {
          System.out.print(" ");  
          }
          for(int j=i;j>=1;j--)//left
          {
          System.out.print(j);  
          }
          for(int j=2;j<=i;j++)//right
          {
          System.out.print(j);  
          }
          System.out.println();
        }
    }

    void startriangle(int r)
    {
        int rows=r;
        for(int i=1;i<=rows;i++)
        {
          for(int j=rows;j>=i;j--)
         {
          System.out.print(" ");  
         }
         for(int k=1;k<=i;k++)
         {
          System.out.print("* ");
         }
         System.out.println();
        }
    }

    void butterfly_star(int r)
    {
      
    }


    public static void main(String args[])
    {
        Pattern1 obj=new Pattern1();
        
        obj.startriangle(4);
    }

}
