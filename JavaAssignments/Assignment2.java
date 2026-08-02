class Student {
    String name;
    int rollNo;

    //default constructor
    Student() {
        name = "Unknown";
        rollNo = 0;
    }

    //parameterized constructor
    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    //copy constructor
    Student(Student s) {
        this.name = s.name;
        this.rollNo = s.rollNo;
    }

    void display() {
        System.out.println("Name: " + name + ", Roll No: " + rollNo);
    }
}

class MobilePhone {
    String brand;
    double price;
    int storage;

    MobilePhone() {
        brand = "unknown";
        price = 0.0;
        storage = 0;
    }

    MobilePhone(String brand, double price, int storage) {
        this.brand = brand;
        this.price = price;
        this.storage = storage;
    }

    MobilePhone(MobilePhone m) {
        this.brand = m.brand;
        this.price = m.price;
        this.storage = m.storage;
    }

    void display() {
        System.out.println("Brand: " + brand + ", Price: " + price + ", Storage: " + storage + "GB");
    }
}

public class Assignment2 {
    public static void main(String[] args) {
        //calling Student constructors
        Student s1 = new Student();
        Student s2 = new Student("Aditya", 101);
        Student s3 = new Student(s2);

        System.out.println("\nStudent Records:");
        s1.display();
        s2.display();
        s3.display();

        //calling MobilePhone constructors
        MobilePhone m1 = new MobilePhone();
        MobilePhone m2 = new MobilePhone("Samsung", 25000.0, 128);
        MobilePhone m3 = new MobilePhone(m2);

        System.out.println("\nMobile Phone Inventory:");
        m1.display();
        m2.display();
        m3.display();
    }
}