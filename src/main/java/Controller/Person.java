package Controller;


public abstract class Person {
    protected String firstName;
    protected String name;
    protected java.sql.Date age;
    protected int age_int;
    protected String email;

    public Person(String name, String firstName, java.sql.Date age,String email){
        this.name = name;
        this.firstName = firstName;
        this.age = age;
        this.email = email;
    }
//------------------------------SET------------------------------------------------------------------------
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
//----------------------------------------------------------------------------------------------------------
}
