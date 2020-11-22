package Controller;

public class Employee extends Person{

    String email;
    public Employee(String name, String firstName, java.sql.Date age,String email){
        super(name, firstName, age,email);
    }

    @Override
    public double calculateDiscount() {
        // Employee have 20% of reduction on any tickets
        return 0.80;
    }
}
