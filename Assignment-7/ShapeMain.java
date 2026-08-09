
class Shape
{
    void area()
    {
        System.out.println("Area Calculation");
    }
}

class Circle extends Shape
{
    double r;

    Circle(double r)
    {
        this.r=r;
    }

    void area()
    {
        double a=3.14*r*r;
        System.out.println("Area of Circle = " +a);
    }
}

class Rectangle extends Shape
{
    double l, b;

    Rectangle(double l, double b)
    {
        this.l=l;
        this.b=b;
    }

    void area()
    {
        double a =l*b;
        System.out.println("Area of Rectangle = " +a);
    }
}

public class ShapeMain
{
    public static void main(String args[])
    {
        Circle c = new Circle(7);
        Rectangle r = new Rectangle(8, 5);

        c.area();
        r.area();
    }
}