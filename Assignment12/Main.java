package Assignment12;
import Assignment12.student.Student;
import Assignment12.faculty.Faculty;

public class Main
{
    public static void main(String args[])
    {
        Student s = new Student("Aditya Nair",284);
        Faculty f = new Faculty("Prof. Akash Bhattacharyya","Java");

        s.display();
        System.out.println();
        f.display();
    }
}