package Model;

//IMPORT
import Controller.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

//A FAIR : /
//       :  Add functionality to add and remove availability of Ride in Time table;


// The ModelSQL class manages data of our application.
// She tak raw information in the data base and convert them in exploitable data for our application
public class ModelSQL {

    // VARIABLES
    private final ArrayList<Ride> rideList;
    private final ArrayList<Person> personList;
    private final HashMap<java.sql.Date,ArrayList<RideAgenda>> agenda;
    private Statement stmt;

    public ModelSQL(Connection conn) {
        //INIT ARRAY
        rideList = new ArrayList<Ride>();
        personList = new ArrayList<Person>();
        agenda = new HashMap<Date, ArrayList<RideAgenda>>();

        //SELECT AND ORGANISE DATA FROM DATABASE
        try {
            // TAKE PERSON TABLE
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM Ride");
            while (res.next()) {
                rideList.add(new Ride(res.getString(1), res.getInt(2), res.getDouble(3)));
            }
            //TAKE LIST OF RIDE AVAILABLE
            res = stmt.executeQuery("SELECT * FROM Person");
            while (res.next()) {
                if (res.getBoolean(6))
                    personList.add(new Employee(res.getString(1), res.getString(2), res.getDate(3), res.getString(4)));
                else
                    personList.add(new Member(res.getString(1), res.getString(2), res.getDate(3), res.getString(4)));
            }

            //CONSTRUCTION OF AGENDA
            res = stmt.executeQuery("SELECT * FROM Time");
            while (res.next()){
                //Initialise ArrayList and date Key
                agenda.putIfAbsent(res.getDate(2), new ArrayList<RideAgenda>());
                //Search for match with a Ride
                for(int i=0; i<rideList.size();i++)
                {
                    if(res.getString(1).equals(rideList.get(i).getName()))
                        // we add an RideAgenda
                        agenda.get(res.getDate(2)).add(new RideAgenda(rideList.get(i),res.getInt(3),res.getDouble(4)));
                }
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }

    }
    //----------------------------Get--------------------------------------------------------------------
    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public ArrayList<Ride> getRideList() {
        return rideList;
    }

    public HashMap<Date, ArrayList<RideAgenda>> getAgenda() {
        return agenda;
    }

    //------------------------------------------------------------------------------------------------------

    //------------------------------EXECUTE QUERY/UPDATE---------------------------------------------------

    //ADD NEW MEMBER
    public void db_AddMember(String firstName, String name, java.sql.Date age, String email,String passwd) {

        personList.add(new Member(name,firstName,age,email));
        String query = "INSERT INTO Person "+
                        "(name,firstName,date_naissance,email,mdp,employBool) VALUES"
                        + "("
                        + "'"+ name +"'"+","
                        +"'"+ firstName +"'"+","
                        +"'"+age +"'"+","
                        +"'"+email +"'"+","
                        +"'"+passwd+"'"+","
                        +"'"+"0"+"'"
                        +   ")";
        try {
            stmt.executeUpdate(query);
        }
        catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }

    }

    public void db_DeleteMember(String email){
        for(int i=0; i<personList.size();i++){
            if(email.equals(personList.get(i).getEmail())){
                personList.remove(i);
                break;
            }
        }
        String query = "DELETE FROM Person " +
                "WHERE email = " + "'"+email+"'";
        try {
            stmt.executeUpdate(query);
        }
        catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    //ADD NEW RIDE
    public void db_addRide(String name,int nbrPlace,double price){
        rideList.add(new Ride(name, nbrPlace, price));
        String query ="INSERT INTO Ride "+
                "(name,placeNbr,price) VALUES"
                + "("
                + "'"+ name +"'"+","
                +"'"+ nbrPlace +"'"+","
                +"'"+price +"'"
                +   ")";
        try {
            stmt.executeUpdate(query);
        }
        catch (SQLException e) {
        System.out.println("SQLException: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
        System.out.println("VendorError: " + e.getErrorCode());

        }
    }

    //DELET A RIDE
    public void db_DeleteRide(String name){
        for(int i=0; i<rideList.size();i++){
            if(name.equals(rideList.get(i).getName())){
                rideList.remove(i);
                break;
            }
        }
        //DELETE IN AGENDA
        for (ArrayList<RideAgenda> a : agenda.values()){
            for (int i = 0; i < a.size(); i++) {
                if(a.get(i).getRide().getName().equals(name))
                    a.remove(i);
            }
        }
        String query1 = "DELETE FROM Time " +
                "WHERE name = " + "'"+name+"'";
        String query2 = "DELETE FROM Ride " +
                "WHERE name = " + "'"+name+"'";
        try {
            stmt.executeUpdate(query1);
            stmt.executeUpdate(query2);
        }
        catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());

        }
    }

    //ADD BOOKING TO AGENDA
    public void db_addAgenda(String name,java.sql.Date date,double price){
        agenda.putIfAbsent(date,new ArrayList<RideAgenda>());
        for (int i=0; i<rideList.size(); i++){
            //find the corresponding Ride to put in RideAgenda
            if(rideList.get(i).getName().equals(name)) {
                agenda.get(date).add(new RideAgenda(rideList.get(i), 0,price));
                break;
            }
        }
        String query = "INSERT INTO Time (name,date_m,placeNbrUsed,price) VALUES"+
                        "("
                         + "'"+ name +"'"+","
                         +"'"+ date +"'"+","
                         +"'"+0+"'"+","
                         +"'"+price+"'"
                         +   ")";
        try {
            stmt.executeUpdate(query);

        }catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());

        }

    }

    public void db_DeleteAgenda(String name, java.sql.Date date){
        ArrayList<RideAgenda> a = agenda.get(date);
        for (int i = 0; i < a.size(); i++) {
            if (name.equals(a.get(i)))
                a.remove(i);
        }
        String query = "DELETE FROM Time WHERE "+
                        "name = "+"'"+name+"'"
                        +" AND date_m = "+"'"+date+"'";

        try {
            stmt.executeUpdate(query);

        }catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());

        }
    }

    public void db_UpdateRidePrice(String name,java.sql.Date date,double price){
        ArrayList<RideAgenda> a = agenda.get(date);
        for (int i=0; i<a.size();i++){
            if(name.equals(a.get(i).getRide().getName()))
                a.get(i).setPrice(price);
        }
        String query = "UPDATE Time SET price="+"'"+price+"'"+
                        "WHERE name="+"'"+name+"'"
                        +"AND date_m="+"'"+date+"'";
        try {
            stmt.executeUpdate(query);
        }catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());

        }
    }

    public void bookARide(java.sql.Date date, String nameRide,String email ,double price, int nbrOfTicket, String reduction){

        double reductionDouble = 1;
        if(reduction.equals("Normal"))
            reductionDouble=1;
        else if(reduction.equals("Senior"))
            reductionDouble=0.9;
        else if(reduction.equals("Child"))
            reductionDouble=0.7;
        else if(reduction.equals("Young"))
            reductionDouble=0.85;

        String query = "INSERT INTO History (customerEmail,rideName,dateOfRide,numberOfTickets,price) VALUES"+
                "("
                + "'"+ email +"'"+","
                +"'"+ nameRide +"'"+","
                +"'"+date+"'"+","
                +"'"+nbrOfTicket+"'"+","
                +"'"+price*reductionDouble+"'"
                +   ")";

        try {
            stmt.executeUpdate(query);
            db_updateNbrPlaceInBook(nameRide,date,nbrOfTicket);
        }catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    public void db_updateNbrPlaceInBook(String rideName,java.sql.Date date,int nbrOfTickets){

        try {

            String queryNbrOfTickets = "SELECT placeNbrUsed FROM Time "+
                    "WHERE name="+"'"+rideName+"'"
                    +"AND date_m="+"'"+date+"'";
            ResultSet res = stmt.executeQuery(queryNbrOfTickets);
            if(res.next())
            nbrOfTickets+=res.getInt(1);

            String query = "UPDATE Time SET placeNbrUsed="+"'"+nbrOfTickets+"'"+
                    "WHERE name="+"'"+rideName+"'"
                    +"AND date_m="+"'"+date+"'";
            stmt.executeUpdate(query);
        }catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
//---------------------------------------------------------------------------------------------------------
//--------------------------------------CECK AND VERIF-----------------------------------------------------
public boolean checkIfRideAgendaExist(String name,java.sql.Date date){
     String query = "SELECT * FROM Time WHERE "
                    +"name = "+"'"+name+"'"
                    +" AND date_m = "+ "'" +date+ "'";
     try {
         ResultSet res = stmt.executeQuery(query);
         if (res.next())
             return true;
         else
             return false;
     }
     catch (SQLException e) {
         System.out.println("SQLException: " + e.getMessage());
         System.out.println("SQLState: " + e.getSQLState());
         System.out.println("VendorError: " + e.getErrorCode());

     }
    return false;
}


public String getPasswdFor(String user){
       String passwd = null;
       String query = "SELECT mdp FROM Person WHERE email = " + "'"+user+"'";

       try {
           ResultSet res = stmt.executeQuery(query);
           if(res.next()){
               passwd = res.getString(1);
           }
       }catch (SQLException e) {
           System.out.println("SQLException: " + e.getMessage());
           System.out.println("SQLState: " + e.getSQLState());
           System.out.println("VendorError: " + e.getErrorCode());

       }

       return passwd;
}

 public boolean isAnEmployee(String user){

        String query = "SELECT employBool FROM Person WHERE email = " + "'"+user+"'";
        Boolean isEmployee = false;

        try {
            ResultSet res = stmt.executeQuery(query);
            if(res.next())
                isEmployee = res.getBoolean(1);
        }catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());

        }
        return isEmployee;
 }
//-----------------------------------------------------------------------------------------------------

}



