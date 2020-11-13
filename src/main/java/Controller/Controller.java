package Controller;

//IMPORT
import Model.ModelSQL;
import java.util.ArrayList;

public class Controller {

    private ModelSQL mSql;

    public Controller(ModelSQL mSql){
            this.mSql = mSql;
    }

    // CHECK IF WE CAN ADD A NEW MEMBER
    public boolean db_addMember(String fisrtName, String name, java.sql.Date age, String email,String passwd){
        ArrayList<Person> personList= mSql.getPersonList();

        for (int i = 0; i < personList.size(); i++) {
            if(email.equals(personList.get(i).getEmail()))
                return false;
        }
        mSql.db_AddMember(fisrtName, name, age, email,passwd);
        return true;
    }

}
