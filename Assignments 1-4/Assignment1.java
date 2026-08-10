public class Assignment1 
{

    //instance variables
    int rollNo;
    String name;
    double marks;

    //default constructor
    Assignment1() {
        rollNo = 0;
        name = "unknown";
        marks = 0.0;
        System.out.println("Default Constructor Called");
    }

    //parameterized constructor
    Assignment1(int r, String n, double m) {
        rollNo = r;
        name = n;
        marks = m;
        System.out.println("Parameterized Constructor Called");
    }


    void displayDetails() {
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Marks   : " + marks);
    }


    String calculateGrade() {
        if (marks >= 90)
            return "A";
        else if (marks >= 75)
            return "B";
        else if (marks >= 60)
            return "C";
        else if (marks >= 40)
            return "D";
        else
            return "F";
    }

    static void javaEnvironment() //static method to display environment details
    {
        System.out.println("JDK : Java Development Kit");
        System.out.println("JRE : Java Runtime Environment");
        System.out.println("JVM : Java Virtual Machine");
        System.out.println();
    }

    public static void main(String[] args) {

        javaEnvironment();

        //default constructor
        Assignment1 obj1 = new Assignment1();
        obj1.displayDetails();
        System.out.println("Grade : " + obj1.calculateGrade());

        System.out.println();

        //using parameterized constructor
        Assignment1 obj2 = new Assignment1(284, "Aditya", 92.5);
        obj2.displayDetails();
        System.out.println("Grade : " + obj2.calculateGrade());
    }
}