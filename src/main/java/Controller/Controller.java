package Controller;

//IMPORT
import Model.ModelSQL;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

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

    public boolean db_DeleteAgenda(String name, java.sql.Date date){
        ArrayList<RideAgenda> a = mSql.getAgenda().get(date);
        if(a==null)
            return false;

        //if we find at less one name equale we can delet
        for (int i = 0; i < a.size(); i++) {
            if (name.equals(a.get(i).getRide().getName())) {
                mSql.db_DeleteAgenda(name, date);
                return true;
            }
        }
        return false;
    }
//BLINDER ADD AGENDA
    public boolean db_addAgenda(String name,java.sql.Date date,double price){
        if(mSql.checkIfRideAgendaExist(name,date)){
            return false;
        }

        mSql.db_addAgenda(name, date, price);
        return true;

    }

     public boolean db_UpdateRidePrice(String name,java.sql.Date date,double price){
         ArrayList<Ride> rideList= mSql.getRideList();

         if(mSql.getAgenda().get(date)==null)
             return false;

         for (int i = 0; i < rideList.size() ; i++) {
             if (name.equals(rideList.get(i).getName())) {
                 mSql.db_UpdateRidePrice(name, date, price);
                 return true;
             }
         }
         return false;
     }

     public boolean bookARide(java.sql.Date date, String nameRide,String email,double price,int nbrOfTickets,String reduction){
         if(!mSql.checkIfRideAgendaExist(nameRide,date)){
             return false;
         }
         mSql.bookARide(date,nameRide,email,price,nbrOfTickets,reduction);
         return true;
     }

     public Person getPerson(String email){
        return mSql.getPerson(email);
     }
     public HashMap<java.sql.Date,ArrayList<RideAgenda>> getAgenda(){ return mSql.getAgenda(); }
     public ArrayList<Ride> getRideList(){return mSql.getRideList();}
     public ArrayList<Person> getPersonList(){return mSql.getPersonList();}


    //---------------------------------------------------------------------------------------------------------
    //--------------------------------VERIFICATION FUNCTIONS-------------------------------------------------------------

    public boolean signIn_check(String user,String passwd){

        String pass = mSql.getPasswdFor(user);
        if(pass==null)
            return false;
        else return passwd.equals(pass);

    }

    public boolean isAnEmployee(String user){
        return mSql.isAnEmployee(user);
    }

    public boolean canIBook(int nbrOfTickets, Date date, RideAgenda ride) {
        return (nbrOfTickets + ride.getPlaceNbrUsed()) <= ride.getRide().getNbrPlace();
    }
    
    public int getTotalPlaceUsedRide(String name) {
    	return(mSql.getTotalBookedPlace(name));
    }

    //----------------------------------------------------------------------------------------
}
