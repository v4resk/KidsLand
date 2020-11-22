package Controller;

import java.time.Period;
import java.util.Calendar;

public class Member extends Person {

    public Member(String name, String firstName, java.sql.Date age, String email)
    {
        super(name, firstName, age,email);
    }

    @Override
    public double calculateDiscount() {
        java.sql.Date dateNow = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        System.out.println(dateNow);
        double reduc=1;

        int age_m = Period.between(age.toLocalDate(),dateNow.toLocalDate()).getYears();

        if(age_m<11)
            reduc=0.70; // 30% of for child
        else if(age_m<25)
            reduc=0.85; //15% for student
        else if(age_m>70)
            reduc=0.90; // 10% for old people

        return reduc;
    }
}
