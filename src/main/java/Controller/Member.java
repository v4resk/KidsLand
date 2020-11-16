package Controller;

public class Member extends Person {

    public Member(String name, String firstName, java.sql.Date age, String email)
    {
        super(name, firstName, age,email);
    }

    @Override
    public double calculateDiscount() {
        return 0.80;
    }
}
