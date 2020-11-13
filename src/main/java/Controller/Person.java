package Controller;


public abstract class Person {
    protected String firstName;
    protected String name;
    protected float age;


    public Person(String name, String firstName, float age){
        this.name = name;
        this.firstName = firstName;
        this.age = age;
    }

}
