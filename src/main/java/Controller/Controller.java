package Controller;

//IMPORT
import Model.ModelSQL;
import java.util.ArrayList;

public class Controller {

    final private ModelSQL mSql;

    public Controller(ModelSQL mSql){
            this.mSql = mSql;
    }

    //----------------------ADD/Remove Member/Ride------------------------------------------------------------
    // CHECK IF WE CAN ADD A NEW MEMBER
    public boolean db_addMember(String firstName, String name, java.sql.Date age, String email,String passwd){
        ArrayList<Person> personList= mSql.getPersonList();

        for (int i = 0; i < personList.size(); i++) {
            if(email.equals(personList.get(i).getEmail()))
                return false;
        }
        mSql.db_AddMember(firstName, name, age, email,passwd);
        return true;
    }
    // CHECK IF WE CAN DELETE MEMBER
    public boolean db_DeleteMember(String email){
        ArrayList<Person> personList= mSql.getPersonList();
        for (int i = 0; i < personList.size(); i++) {
            if(email.equals(personList.get(i).getEmail())){
                mSql.db_DeleteMember(email);
                return true;
            }
        }
        return false;
    }

    // CHECK IF WE CAN ADD A RIDE
    public boolean db_addRide(String name,int nbrPlace,double price){
        ArrayList<Ride> rideList = mSql.getRideList();
        for (int i = 0; i < rideList.size(); i++) {
            if(name.equals(rideList.get(i).getName()))
                return false;
        }

        mSql.db_addRide(name,nbrPlace,price);
        return true;

    }
    //CHECK IF WE CAN DELETE A RIDE
    public boolean db_DeleteRide(String name){
        ArrayList<Ride> rideList= mSql.getRideList();
        for (int i = 0; i < rideList.size(); i++) {
            if(name.equals(rideList.get(i).getName())){
                mSql.db_DeleteRide(name);
                return true;
            }
        }
        return false;
    }

   // public boolean db_UpdateRidePrice(String nom,double price)
    //---------------------------------------------------------------------------------------------------------

}
