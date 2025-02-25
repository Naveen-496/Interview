
// Introduction to Object-Oriented Programming (OOP) in Java
// Object-Oriented Programming (OOP) is a programming paradigm that organizes software design around data, or objects, rather than functions and logic. In Java, OOP is fundamental because it allows developers to create reusable, self-contained components that represent real-world entities. This approach simplifies software development and maintenance by providing several key concepts.

// Key Concepts of OOP in Java
// Classes and Objects

// Classes: A class is a blueprint or template that defines the properties and behaviors of an object. It acts as a factory for creating objects.

// Objects: An object is an instance of a class, having its own set of attributes (data) and methods (functions). Objects represent real-world entities like cars, books, etc.

// Inheritance

// Inheritance allows one class to inherit the properties and methods of another class. The inheriting class is called the subclass or child class, while the class being inherited from is called the superclass or parent class. This promotes code reusability by allowing subclasses to inherit common attributes and methods from their superclasses.

// Polymorphism

// Polymorphism is the ability of an object to take on multiple forms. This can be achieved through method overloading (multiple methods with the same name but different parameters) or method overriding (a subclass provides a different implementation of a method already defined in its superclass).

// Encapsulation

// Encapsulation involves bundling data (attributes) and methods that operate on that data within a single unit, which is the class. This helps in hiding the internal details of an object from the outside world and provides access to the data through controlled methods.

// Abstraction

// Abstraction is the practice of showing only the necessary information to the outside world while hiding the internal details. It helps in reducing complexity by focusing on essential features of an object or system.

// Benefits of OOP in Java
// Code Reusability: Classes and objects can be reused in multiple contexts.

// Easier Maintenance: Changes can be made at the class level, affecting all related objects.

// Scalability: OOP makes it easier to add new features or classes without disrupting existing code.

// Efficiency: Encapsulation and abstraction help in organizing code efficiently.

// Example of OOP Concepts in Java
// Here's a simple example that demonstrates classes, objects, inheritance, polymorphism, encapsulation, and abstraction:

// Example of Class and Object
public class Vehicle {
    private String color;
    private int speed;

    public Vehicle(String color, int speed) {
        this.color = color;
        this.speed = speed;
    }

    public void displayDetails() {
        System.out.println("Color: " + color + ", Speed: " + speed);
    }
}

// Example of Inheritance
public class Car extends Vehicle {
    private int gears;

    public Car(String color, int speed, int gears) {
        super(color, speed);
        this.gears = gears;
    }

    // Example of Polymorphism (Method Overriding)
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Gears: " + gears);
    }
}

// Example of Encapsulation and Abstraction
public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("Red", 120, 5);
        myCar.displayDetails(); // Accessing encapsulated data through methods
    }
}

// In this example, Vehicle is a superclass, and Car is a subclass that inherits
// from Vehicle. The displayDetails() method in Car overrides the one in
// Vehicle, demonstrating polymorphism. The data members are private, showcasing
// encapsulation, and the internal details are hidden from the outside,
// illustrating abstraction.

public class OOP {

}
