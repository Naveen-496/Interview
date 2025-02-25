
// In Java, a constructor is a special method used to initialize objects of a class. It has the same name as the class and is invoked automatically when an object of the class is created. Constructors do not have a return type, not even void. Their primary purpose is to set up the initial state of an object by assigning values to its attributes or performing other necessary setup tasks. 


class Dog {
    String name;
    int age;

    // Constructor
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Dog myDog = new Dog("Buddy", 3); // Creates a Dog object and calls the constructor
        System.out.println("Name: " + myDog.name + ", Age: " + myDog.age);
    }
}


// Key characteristics of constructors:
// Name: Must be identical to the class name.
// No return type: Does not have a return type, not even void.
// Invocation: Automatically called when an object is created using the new keyword.
// Purpose: Initializes the object's state.
// Types:
// Default constructor: If no constructor is explicitly defined, Java provides a default constructor with no arguments.
// Parameterized constructor: Accepts arguments to initialize the object with specific values.
// Copy constructor: While Java doesn't have a built-in copy constructor, it can be implemented to create a new object as a copy of an existing one.
// Overloading: Multiple constructors with different parameter lists can be defined in the same class, a feature known as constructor overloading.
// Restrictions:
// Cannot be abstract, static, or final.
// Cannot be overridden, but can be overloaded.